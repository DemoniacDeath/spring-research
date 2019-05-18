import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Demo';
  greeting: {id?: string, content?: string} = {};
  constructor(private http: HttpClient) {
    http.get("resource").subscribe(data => {
      this.greeting.id = data['id'];
      this.greeting.content = data['content'];
    });
  }
}