import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {UpdateControllerPage} from "../update-controller/update-controller";
import {StoreService} from "../../providers/store-service";
import {SchedulePage} from "../schedule/schedule";

import {ActionService} from "../../providers/action-service";
/**
 * Generated class for the DevicesPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-devices',
  templateUrl: 'devices.html',
})
export class DevicesPage {
data : any =  
      {"C001":{"1":"Light","2":"Fan"},"C005":{"1":"AC","2":"Geyser"},"controllers":{"C001":"Bathroom","C005":"Bedroom"},"homeId":{"homeId":"H1"}};
  
scheduleTime: any ;
roomInfo : any;
updatedData: any;
resposeData: any;
  constructor(public navCtrl: NavController, public navParams: NavParams,private store: StoreService,public actionService : ActionService) {
	
	let rooms =[];
	let i=0;
	 for(var key in this.data.controllers) {
		let roomData ={};
     // alert("Key: " + key + " value: " + this.data.controllers[key]);
	  roomData["id"]=key;
	  roomData["name"]=this.data.controllers[key];
	 let controllerData=this.data[key];
	  let j=0;
	  for(var key1 in controllerData)
	  {
		  j=j+1;
		 roomData["deviceId"+j]=key1;
		roomData["deviceName"+j]=controllerData[key1];
	  }
	  rooms [i]=roomData;
	  i=i+1;
    }
	console.log(rooms);

	this.roomInfo=rooms;
  }
  
  private onConnected():void {
    console.log('Connected to broker.');
  }
edit(room)
{
	//this.roomData=room;
	   this.store.roomData = room;

	  this
      .navCtrl
      .push(UpdateControllerPage);
    
}
schedule(deviceID,roomId)
{
	
	
	let deviceId={};
	deviceId["controllerID"]=roomId;
	deviceId["userID"]="soumyajit0405@gmail.com";
	deviceId["deviceID"]=deviceID;
	 this.store.deviceData = deviceId;

	  this
      .navCtrl
      .push(SchedulePage);
    
}
  ionViewDidLoad() {
    console.log('ionViewDidLoad DevicesPage');
  }

}
