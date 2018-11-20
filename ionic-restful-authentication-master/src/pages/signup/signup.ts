import {Component} from '@angular/core';
import {IonicPage, NavController, ToastController} from 'ionic-angular';
import {AuthServiceCustom} from "../../providers/auth-service";


 
/**
 * Generated class for the Signup page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({selector: 'page-signup', templateUrl: 'signup.html'})
export class Signup {
  resposeData : any;
  userData = {"name":"", "password":"","email":"","phone":""};
  constructor(public navCtrl : NavController, public authService : AuthServiceCustom, private toastCtrl:ToastController ) {}

  ionViewDidLoad() {
    console.log('ionViewDidLoad Signup');
  }
  
  signup() {
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
    console.log(this.resposeData);
    //if(this.resposeData.response.homeId==1){
     //localStorage.setItem('userData', JSON.stringify(this.resposeData) )
	 console.log("Successfully Logged In");
   // this.navCtrl.push(TabsPage);
   
   
	});
	}
	


  }

  presentToast(msg) {
    let toast = this.toastCtrl.create({
      message: msg,
      duration: 2000
    });
    toast.present();
  }

}
