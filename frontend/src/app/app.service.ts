import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {finalize} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AppService {
  get authenticated(): boolean {
    return this._authenticated;
  }

  private _authenticated = false;


  constructor(private http: HttpClient) {
  }

  authenticate(credentials, callback) {
    const headers = new HttpHeaders(credentials ? {
      authorization: 'Basic ' + btoa(
        credentials.username +
        ':' +
        credentials.password
      )
    } : {});

    this.http.get('user', {headers: headers}).subscribe(response => {
      this._authenticated = !!response['name'];
      return callback && callback();
    });
  }

  logout(callback: () => void) {
    this.http.post('logout', {}).pipe(
      finalize(() => {
        this._authenticated = false;
        return callback && callback();
      })
    ).subscribe();

  }
}
