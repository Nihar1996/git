import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {AccountService} from "../../providers/account-service";
/**
 * Generated class for the ChangepasswordPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-changepassword',
  templateUrl: 'changepassword.html',
})
export class ChangepasswordPage {
  resposeData : any;
  userData = {"newpassword":"","confirmpassword":""};

  constructor(public navCtrl: NavController, public navParams: NavParams,public accountService : AccountService) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ChangepasswordPage');
  }
  savePasswordForVendor(){
	  let inputData={};
	  if(this.userData.newpassword==this.userData.confirmpassword)
	  {
		inputData["phone"]=localStorage.getItem("phone") ;// Take from local storage
	  inputData["password"]=this.userData.confirmpassword;  
	   this.accountService.changePasswordForVendor(inputData).then((result) =>{
    this.resposeData = result;
    	if(this.resposeData.status==1)
	{
	 let toast = this.toastCtrl.create({
              message: 'Password Changed',
              duration: 3000,
              position: 'top',
              cssClass: 'dark-trans',
              closeButtonText: 'OK',
              showCloseButton: true
            });
            toast.present();
	
	}
	else{
		 let toast = this.toastCtrl.create({
              message: 'Something is wrong.',
              duration: 3000,
              position: 'top',
              cssClass: 'dark-trans',
              closeButtonText: 'OK',
              showCloseButton: true
            });
            toast.present();
	}

   
	  
	  
	   
   

    }, (err) => {
      //Connection failed message
    });
   }
   else{
    //this.presentToast("Please provide name");
   }
  
  }
  
  savePasswordForUser(){
	  let inputData={};
	  if(this.userData.newpassword==this.userData.confirmpassword)
	  {
		inputData["phone"]=localStorage.getItem("phone") ;// Take from local storage
	  inputData["password"]=this.userData.confirmpassword;  
	   this.accountService.changePasswordForUser(inputData).then((result) =>{
    this.resposeData = result;
    	if(this.resposeData.status==1)
	{
	 let toast = this.toastCtrl.create({
              message: 'Password Changed',
              duration: 3000,
              position: 'top',
              cssClass: 'dark-trans',
              closeButtonText: 'OK',
              showCloseButton: true
            });
            toast.present();
	
	}
	else{
		 let toast = this.toastCtrl.create({
              message: 'Something is wrong.',
              duration: 3000,
              position: 'top',
              cssClass: 'dark-trans',
              closeButtonText: 'OK',
              showCloseButton: true
            });
            toast.present();
	}

   
	  
	  
	   
   

    }, (err) => {
      //Connection failed message
    });
   }
   else{
    //this.presentToast("Please provide name");
   }
  
  }

}
