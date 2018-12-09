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
export class AuthServiceCustom {

  constructor(public http: Http) {
    console.log('Hello AuthService Provider');
  }

  postData(credentials){

    return new Promise((resolve, reject) =>{
      let headers = new Headers();
      this.http.post(loginUrl, {email: credentials.email, password: credentials.password }, {headers: headers}).
      subscribe(res =>{
        resolve(res.json());
      }, (err) =>{
        reject(err);
      });

    });

  }
  
  sendPasswordToMail(credentials){

    return new Promise((resolve, reject) =>{
      let headers = new Headers();
      this.http.post('https://www.autoiinnovations.com/Test/rest/register/sendTemporaryPassword', {email: credentials.email}, {headers: headers}).
      subscribe(res =>{
        resolve(res.json());
      }, (err) =>{
        reject(err);
      });

    });

  }

  signup(credentials){

  let data={};
  data["email"]=credentials.email;
  data["name"]=credentials.name;
  data["phone"]=credentials.phone;
  data["password"]=credentials.password;
  data["mode"]="C";
    return new Promise((resolve, reject) =>{
      let headers = new Headers();
      this.http.post('https://autoiinnovations.com/Test/rest/register/registerMemberWH',data, {headers: headers}).
      subscribe(res =>{
        resolve(res.json());
      }, (err) =>{
        reject(err);
      });

    });

  }

}
