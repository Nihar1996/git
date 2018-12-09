import {Component} from "@angular/core";
import {NavController, AlertController, ToastController, MenuController} from "ionic-angular";
import {HomePage} from "../home/home";
import {RegisterPage} from "../register/register";
import {AuthServiceCustom} from "../../providers/auth-service";
import {DevicesPage} from "../devices/devices";
@Component({
  selector: 'page-login',
  templateUrl: 'login.html'
})
export class LoginPage {
resposeData : any;
  userData = {"username":"", "password":""};
	
  constructor(public nav: NavController, public forgotCtrl: AlertController, public menu: MenuController, public toastCtrl: ToastController,public authService: AuthServiceCustom) {
    this.menu.swipeEnable(false);
  }

  // go to register page
  register() {
    this.nav.setRoot(RegisterPage);
  }

  // login and go to home page
  login() {
    let inputData={};
	  inputData["email"]=this.userData.username;
	  inputData["password"]=this.userData.password;
	   
   if(this.userData.username && this.userData.password){
    this.authService.postData(inputData).then((result) =>{
    this.resposeData = result;
    console.log(this.resposeData);
    if(this.resposeData.homeId.homeId==1){
     //localStorage.setItem('userData', JSON.stringify(this.resposeData) )
	     this.nav.setRoot(DevicesPage);

	 console.log("Successfully Logged In");
   // this.navCtrl.push(TabsPage);
  }
  else{
	  this.nav.setRoot(DevicesPage); //this.presentToast("Please give valid username and password");
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
			     this.authService.sendPasswordToMail(data["email"]).then((result) =>{
    this.resposeData = result;
    console.log(this.resposeData);
    //if(this.resposeData.response.homeId==1){
     //localStorage.setItem('userData', JSON.stringify(this.resposeData) )
	 console.log("Successfully Logged In");
   // this.navCtrl.push(TabsPage);
   
   
	});

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
        }
      ]
    });
    forgot.present();
  }

}
