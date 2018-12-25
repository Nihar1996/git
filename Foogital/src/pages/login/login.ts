import {Component} from "@angular/core";
import {NavController, AlertController, ToastController, MenuController} from "ionic-angular";
import {HomePage} from "../home/home";
import {RegisterPage} from "../register/register";
import {AuthServiceCustom} from "../../providers/auth-service";
import {StoreService} from "../../providers/store-service";
import {DevicesPage} from "../devices/devices";
@Component({
  selector: 'page-login',
  templateUrl: 'login.html'
})
export class LoginPage {
resposeData : any;
  userData = {"phone":"", "password":""};
	
  constructor(public nav: NavController, public forgotCtrl: AlertController, public menu: MenuController, public toastCtrl: ToastController,public authService: AuthServiceCustom,private store: StoreService) {
    this.menu.swipeEnable(false);
  }

  // go to register page
  register() {
    this.nav.setRoot(RegisterPage);
  }

  // login and go to home page
  loginVendor() {
    let inputData={};
	  inputData["phone"]=this.userData.phone;
	  inputData["password"]=this.userData.password;
	   
   if(this.userData.phone && this.userData.password){
    this.authService.loginVendor(inputData).then((result) =>{
    this.resposeData = result;
    console.log(this.resposeData);
    if(this.resposeData.status==1){
		//localStorage.setItem("email",this.userData.email);	
	localStorage.setItem("phone",this.userData.phone);	
	localStorage.setItem("instituteId",this.resposeData.instId);	
	localStorage.setItem("vendorId",this.resposeData.vendorId);	
	 this.nav.setRoot(DevicesPage);

	 console.log("Successfully Logged In");
   // this.navCtrl.push(TabsPage);
  }
  else if(this.resposeData.status==0){
	  let toast = this.toastCtrl.create({
              message: 'Wrong Credentials',
              duration: 3000,
              position: 'top',
              cssClass: 'dark-trans',
              closeButtonText: 'OK',
              showCloseButton: true
            });
            toast.present();
	 // this.nav.setRoot(DevicesPage); //this.presentToast("Please give valid username and password");
  }
  else {
	  let toast = this.toastCtrl.create({
              message: 'Something went wrong',
              duration: 3000,
              position: 'top',
              cssClass: 'dark-trans',
              closeButtonText: 'OK',
              showCloseButton: true
            });
            toast.present();
	 // this.nav.setRoot(DevicesPage); //this.presentToast("Please give valid username and password");
  }
    


    }, (err) => {
      //Connection failed message
    });
   }
   else{
   // this.presentToast("Give username and password");
   }
  }

  
  loginUser() {
    let inputData={};
	  inputData["phone"]=this.userData.phone;
	  inputData["password"]=this.userData.password;
	   
   if(this.userData.phone && this.userData.password){
    this.authService.loginUser(inputData).then((result) =>{
    this.resposeData = result;
    console.log(this.resposeData);
    if(this.resposeData.status==1){
		//localStorage.setItem("email",this.userData.email);	
	localStorage.setItem("phone",this.userData.phone);	
	localStorage.setItem("instituteId",this.resposeData.instId);	
	localStorage.setItem("userId",this.resposeData.userId);	
	 this.nav.setRoot(DevicesPage);

	 console.log("Successfully Logged In");
   // this.navCtrl.push(TabsPage);
  }
  else if(this.resposeData.status==0){
	  let toast = this.toastCtrl.create({
              message: 'Wrong Credentials',
              duration: 3000,
              position: 'top',
              cssClass: 'dark-trans',
              closeButtonText: 'OK',
              showCloseButton: true
            });
            toast.present();
	 // this.nav.setRoot(DevicesPage); //this.presentToast("Please give valid username and password");
  }
  else {
	  let toast = this.toastCtrl.create({
              message: 'Something went wrong',
              duration: 3000,
              position: 'top',
              cssClass: 'dark-trans',
              closeButtonText: 'OK',
              showCloseButton: true
            });
            toast.present();
	 // this.nav.setRoot(DevicesPage); //this.presentToast("Please give valid username and password");
  }
    


    }, (err) => {
      //Connection failed message
    });
   }
   else{
   // this.presentToast("Give username and password");
   }
  }

  forgotPass() {
    let forgot = this.forgotCtrl.create({
      title: 'Forgot Password?',
      message: "Enter you email address to send a reset link password.",
      inputs: [
        {
          name: 'email',
          placeholder: 'Email',
          type: 'email'
        },
      ],
      buttons: [
        {
          text: 'Cancel',
          handler: data => {
            console.log('Cancel clicked');
          }
        },
        {
          text: 'Send',
          handler: data => {
            console.log('Send clicked' + data["email"]);
			let inputData={};
			inputData["email"]=data["email"];
			inputData["userType"]="vendor";

			     this.authService.sendPasswordToMail(inputData).then((result) =>{
    this.resposeData = result;
	if(resposeData.status==1)
	{
		 let toast = this.toastCtrl.create({
              message: 'Email was sended successfully',
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
    console.log(this.resposeData);
    //if(this.resposeData.response.homeId==1){
     //localStorage.setItem('userData', JSON.stringify(this.resposeData) )
	 console.log("Successfully Logged In");
   // this.navCtrl.push(TabsPage);
   
   
	});

           
          }
        }
      ]
    });
    forgot.present();
  }

}
