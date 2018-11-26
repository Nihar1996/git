import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {ActionService} from "../../providers/action-service";

/**
 * Generated class for the AddcontrollerPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-addcontroller',
  templateUrl: 'addcontroller.html',
})
export class AddcontrollerPage {

resposeData : any;
  controllerData = {"cid":"", "pkey":"","rname":"","d1":"","d2":""};
  constructor(public navCtrl: NavController, public navParams: NavParams,public actionService : ActionService) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad AddcontrollerPage');
  }
  add() {
	 // console.log(this.userData);
    
   
	  let inputData={};
	  inputData["controllerId"]=this.controllerData.cid;
	  inputData["passKey"]=this.controllerData.pkey;
	  inputData["userName"]="soumyajit0405@gmail.com";//  Get from login
	  inputData["controllerName"]=this.controllerData.rname;
	  inputData["device1"]=this.controllerData.d1;
	  inputData["device2"]=this.controllerData.d2;
	//  console.log(inputData["email"]);
	  if(inputData["controllerId"]){
     this.actionService.addController(inputData).then((result) =>{
    this.resposeData = result;
    console.log(this.resposeData);
    //if(this.resposeData.response.homeId==1){
     //localStorage.setItem('userData', JSON.stringify(this.resposeData) )
	 console.log("Successfully Logged In");
   // this.navCtrl.push(TabsPage);
   
   
	});
	}
	


  }


}
