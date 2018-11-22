import {Component} from '@angular/core';
import {IonicPage, NavController, ToastController} from 'ionic-angular';
import {AccountService} from "../../providers/account-service";


 
/**
 * Generated class for the Signup page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({selector: 'page-profile', templateUrl:'profile.html'})
export class ProfilePage {
  resposeData : any;
  userData = {"name":"","email":"","phone":""};
  constructor(public navCtrl : NavController, public accountService : AccountService, private toastCtrl:ToastController ) {
	  
	  let inputData={};
	  inputData["email"]="soumyajit0405@gmail.com";
	   this.accountService.getProfileData(inputData).then((result) =>{
    this.resposeData = result;
    console.log(this.resposeData);
	if(this.resposeData.key==777)
	{
	this.userData.email=	this.resposeData.email;
	this.userData.phone=	this.resposeData.phone;
	this.userData.name=	this.resposeData.name;
	
	
	}
    //if(this.resposeData.response.homeId==1){
     //localStorage.setItem('userData', JSON.stringify(this.resposeData) )
	 console.log("Successfully Logged In");
   // this.navCtrl.push(TabsPage);
   
   
	});
	
	  
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad Signup');
  }
  

  presentToast(msg) {
    let toast = this.toastCtrl.create({
      message: msg,
      duration: 2000
    });
    toast.present();
  }

}
