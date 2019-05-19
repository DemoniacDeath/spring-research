import {Component, OnInit} from '@angular/core';
import {AppService} from "../app.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  greeting: { id?: string, content?: string } = {};

  constructor(private app: AppService, private http: HttpClient) {
    http.get('resource').subscribe(data => {
      this.greeting.id = data['id'];
      this.greeting.content = data['content'];
    }, () => {
    });
  }

  authenticated() {
    return this.app.authenticated;
  }

  ngOnInit() {
  }

}
