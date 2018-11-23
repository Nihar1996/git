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
  save(){
	  let inputData={};
	  if(this.userData.newpassword==this.userData.confirmpassword)
	  {
		inputData["email"]="soumyajit0405@gmail.com" ;// Take from local storage
	  inputData["password"]=this.userData.confirmpassword;  
	   this.accountService.changePassword(inputData).then((result) =>{
    this.resposeData = result;
    console.log(this.resposeData);
   
	  
	  
	   
   

    }, (err) => {
      //Connection failed message
    });
   }
   else{
    //this.presentToast("Please provide name");
   }
  
  }
  
  

}
