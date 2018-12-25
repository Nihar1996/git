import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import 'rxjs/add/operator/map';

//let apiUrl = "http://localhost/PHP-Slim-Restful/api/";
let loginUrl = 'https://www.autoiinnovations.com/Test/rest/login/authenticateUserWH';
/*
  Generated class for the AuthService provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular 2 DI.
*/
@Injectable()
export class UserService {

  constructor(public http: Http) {
    console.log('Hello AccountService Provider');
  }

  
  
  
  
  bookOrder(credentials){

    return new Promise((resolve, reject) =>{
      let headers = new Headers();
      this.http.post('https://www.autoiinnovations.com/TestProject/rest/user/bookFood', {credentials}, {headers: headers}).
      subscribe(res =>{
        resolve(res.json());
      }, (err) =>{
        reject(err);
      });

    });

  }
  
  showCurrentBooking(credentials){

    return new Promise((resolve, reject) =>{
      let headers = new Headers();
      this.http.post('https://www.autoiinnovations.com/TestProject/rest/user/showMyCurrentBooking', {credentials}, {headers: headers}).
      subscribe(res =>{
        resolve(res.json());
      }, (err) =>{
        reject(err);
      });

    });

  }
 
 showPreviousBooking(credentials){

    return new Promise((resolve, reject) =>{
      let headers = new Headers();
      this.http.post('https://www.autoiinnovations.com/TestProject/rest/user/showPreviousBookings', {credentials}, {headers: headers}).
      subscribe(res =>{
        resolve(res.json());
      }, (err) =>{
        reject(err);
      });

    });

  }
  
 showMenu(credentials){

    return new Promise((resolve, reject) =>{
      let headers = new Headers();
      this.http.post('https://www.autoiinnovations.com/TestProject/rest/user/showMenu', {credentials}, {headers: headers}).
      subscribe(res =>{
        resolve(res.json());
      }, (err) =>{
        reject(err);
      });

    });

  } 

}
