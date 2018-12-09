import { Injectable } from '@angular/core';



//let apiUrl = "http://localhost/PHP-Slim-Restful/api/";

/*
  Generated class for the AuthService provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular 2 DI.
*/
@Injectable()
export class StoreService {

	roomData : any;
	deviceData : any;
  constructor() {
    console.log('Hello AccountService Provider');
  }

}
