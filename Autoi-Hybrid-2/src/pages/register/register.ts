import {Component} from "@angular/core";
import {NavController} from "ionic-angular";
import {LoginPage} from "../login/login";
import {HomePage} from "../home/home";
import {AuthServiceCustom} from "../../providers/auth-service";

@Component({
  selector: 'page-register',
  templateUrl: 'register.html'
})
export class RegisterPage {
resposeData : any;
  userData = {"name":"", "password":"","email":"","phone":""};
  
  constructor(public nav: NavController,public authService : AuthServiceCustom) {
  }

  // register and go to home page
  register() {
	    console.log(this.userData);
    
   
	  let inputData={};
	  inputData["email"]=this.userData.email;
	  inputData["name"]=this.userData.name;
	  inputData["phone"]=this.userData.phone;
	  inputData["password"]=this.userData.password;
	  console.log(inputData["email"]);
	  if(inputData["email"]){
     this.authService.signup(inputData).then((result) =>{
    this.resposeData = result;
	 this.nav.setRoot(HomePage);
    console.log(this.resposeData);
    //if(this.resposeData.response.homeId==1){
     //localStorage.setItem('userData', JSON.stringify(this.resposeData) )
	 console.log("Successfully Logged In");
   // this.navCtrl.push(TabsPage);
   
   
	});
	}
	
   
  }

  // go to login page
  login() {
    this.nav.setRoot(LoginPage);
  }
}
