import {Component} from '@angular/core';
import {IonicPage, NavController, ToastController} from 'ionic-angular';
import {AccountService} from "../../providers/account-service";
import {ChangepasswordPage} from "../changepassword/changepassword";

 
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
	  inputData["phone"]=localStorage.getItem("phone");
	  //vendor 
	   this.accountService.getUserProfileData(inputData).then((result) =>{
    this.resposeData = result;
    console.log(this.resposeData);
	if(this.resposeData.status==1)
	{
	this.userData.email=	this.resposeData.email;
	this.userData.phone=	localStorage.getItem("phone");
	this.userData.name=	this.resposeData.name;
	
	
	}
	else if(this.resposeData.status==0)
	{
		 let toast = this.toastCtrl.create({
              message: 'No Profile Found',
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
    //if(this.resposeData.response.homeId==1){
     //localStorage.setItem('userData', JSON.stringify(this.resposeData) )
	 console.log("Successfully Logged In");
   // this.navCtrl.push(TabsPage);
   
   
	});
	
	  
	    this.accountService.getVendorProfileData(inputData).then((result) =>{
    this.resposeData = result;
    console.log(this.resposeData);
	if(this.resposeData.status==1)
	{
	this.userData.email=	this.resposeData.email;
	this.userData.phone=	localStorage.getItem("phone");
	this.userData.name=	this.resposeData.name;
	
	
	}
	else if(this.resposeData.status==0)
	{
		 let toast = this.toastCtrl.create({
              message: 'No Profile Found',
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

  saveUserDetails(){
	  let inputData={};
	  
	  inputData["phone"]=this.userData.phone;
	  inputData["name"]=this.userData.name;
	   
   if(this.userData.name){
    this.accountService.saveUserProfileData(inputData).then((result) =>{
    this.resposeData = result;
    console.log(this.resposeData);
	 	if(this.resposeData.status==1)
	{
	 let toast = this.toastCtrl.create({
              message: 'Profie Updated',
              duration: 3000,
              position: 'top',
              cssClass: 'dark-trans',
              closeButtonText: 'OK',
              showCloseButton: true
            });
            toast.present();
	
	}
	else if(this.resposeData.status==0)
	{
		 let toast = this.toastCtrl.create({
              message: 'No Profile Found',
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

    /* if(this.resposeData.homeId.homeId==1){
     //localStorage.setItem('userData', JSON.stringify(this.resposeData) )
	 //    this.navCtrl.setRoot(MenuPage);

	 console.log("Successfully Logged In");
   // this.navCtrl.push(TabsPage);
  }
  else{
	  /* this
      .navCtrl
      .push(MenuPage); 
    this.presentToast("Please give valid username and password");
  } */
    


    }, (err) => {
      //Connection failed message
    });
   }
   else{
    this.presentToast("Please provide name");
   }
  
  }
  
    saveVendorDetails(){
	  let inputData={};
	  
	  inputData["phone"]=this.userData.phone;
	  inputData["name"]=this.userData.name;
	   
   if(this.userData.name){
    this.accountService.saveVendorProfileData(inputData).then((result) =>{
    this.resposeData = result;
    	if(this.resposeData.status==1)
	{
	 let toast = this.toastCtrl.create({
              message: 'Profie Updated',
              duration: 3000,
              position: 'top',
              cssClass: 'dark-trans',
              closeButtonText: 'OK',
              showCloseButton: true
            });
            toast.present();
	
	}
	else if(this.resposeData.status==0)
	{
		 let toast = this.toastCtrl.create({
              message: 'No Profile Found',
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

    /* if(this.resposeData.homeId.homeId==1){
     //localStorage.setItem('userData', JSON.stringify(this.resposeData) )
	 //    this.navCtrl.setRoot(MenuPage);

	 console.log("Successfully Logged In");
   // this.navCtrl.push(TabsPage);
  }
  else{
	  /* this
      .navCtrl
      .push(MenuPage); 
    this.presentToast("Please give valid username and password");
  } */
    


    }, (err) => {
      //Connection failed message
    });
   }
   else{
    this.presentToast("Please provide name");
   }
  
  }
  changePassword()
  {
	   this.navCtrl.setRoot(ChangepasswordPage);
	   
  }
}
