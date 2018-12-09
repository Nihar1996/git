import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {DevicesPage} from "../devices/devices";
import {StoreService} from "../../providers/store-service";
import {ActionService} from "../../providers/action-service";
/**
 * Generated class for the UpdateControllerPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-update-controller',
  templateUrl: 'update-controller.html',
})
export class UpdateControllerPage {
 controllerData = {"cid":"", "pkey":"","rname":"","d1":"","d2":""};
 resposeData : any;
  constructor(public navCtrl: NavController, public navParams: NavParams,public store: StoreService,public actionService : ActionService) {
	  console.log("Data from devices page"+this.store.roomData.name)
	  this.controllerData.rname=this.store.roomData.name;
	  this.controllerData.d1=this.store.roomData.deviceName1;
	  this.controllerData.d2=this.store.roomData.deviceName2;
	  
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad UpdateControllerPage');
  }
  
  edit()
  {
	    let controllerData={};
	  controllerData[this.store.roomData.id]=this.controllerData.rname;
	  let deviceData={};
	  deviceData[this.store.roomData.deviceId1]=this.controllerData.d1;
	  deviceData[this.store.roomData.deviceId2]=this.controllerData.d2;
	  let inputData={};
	  inputData["controllers"]=controllerData;
	  inputData["devices"]=deviceData;
	  console.log("data to be updated" +inputData);
	//  console.log(inputData["email"]);
	  
     this.actionService.editController(inputData).then((result) =>{
    this.resposeData = result;
    console.log(this.resposeData);
    //if(this.resposeData.response.homeId==1){
     //localStorage.setItem('userData', JSON.stringify(this.resposeData) )
	 console.log("Successfully Logged In");
   // this.navCtrl.push(TabsPage);
   
   
	});
	
	
  
	  }
}
