import { Component } from '@angular/core';
import { IonicPage, NavController, ToastController } from 'ionic-angular';

import {AuthServiceCustom} from "../../providers/auth-service";
import {ForgotPasswordPage} from "../forgot-password/forgot-password"
import {Signup} from "../signup/signup"
import {MenuPage} from "../home-1/home-1"

import {
    AuthService,
    
    GoogleLoginProvider
} from 'angular-6-social-login';
/**
 * Generated class for the Login page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
})
export class Login {
  
  resposeData : any;
  userData = {"username":"", "password":""};
	
  constructor(public navCtrl: NavController, public authService: AuthServiceCustom, private toastCtrl:ToastController,private socialAuthService: AuthService) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad Login');
  }
  
   public socialSignIn(socialPlatform : string) {
    let socialPlatformProvider;
    if(socialPlatform == "google"){
      socialPlatformProvider = GoogleLoginProvider.PROVIDER_ID;
    }
    this.socialAuthService.signIn(socialPlatformProvider).then(
      (userData) => {
        console.log(socialPlatform+" sign in data : " , userData);
        // Now sign-in with userData
        // ...
            
      }
    );
  }


  login(){
	  let inputData={};
	  inputData["email"]=this.userData.username;
	  inputData["password"]=this.userData.password;
	   
   if(this.userData.username && this.userData.password){
    this.authService.postData(inputData).then((result) =>{
    this.resposeData = result;
    console.log(this.resposeData);
    if(this.resposeData.homeId.homeId==1){
     //localStorage.setItem('userData', JSON.stringify(this.resposeData) )
	     this.navCtrl.setRoot(MenuPage);

	 console.log("Successfully Logged In");
   // this.navCtrl.push(TabsPage);
  }
  else{
	  this
      .navCtrl
      .push(MenuPage);
    this.presentToast("Please give valid username and password");
  }
    


    }, (err) => {
      //Connection failed message
    });
   }
   else{
    this.presentToast("Give username and password");
   }
  
  }

forgetPassword()
{
	console.log("Inside Forget Password");
	this
      .navCtrl
      .push(ForgotPasswordPage);
}
  presentToast(msg) {
    let toast = this.toastCtrl.create({
      message: msg,
      duration: 2000
    });
    toast.present();
  }

signup()
{
	console.log("Inside Forget Password");
	this
      .navCtrl
      .push(Signup);
}
}
