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
	
	this.data=store.devicesData;
	let rooms =[];
	let i=0;
	let roomData ={};
	 for(var key in this.data.controllers) {
		
     // alert("Key: " + key + " value: " + this.data.controllers[key]);
	 
	  roomData["id"]=key;
	  roomData["name"]=this.data.controllers[key];
	  roomData["security"]=this.data.security[key];
	  roomData["topic"]=this.data.topic[key];
	  let deviceStatus=this.data.status[key];
	  let deviceStatusArray=[];
	  deviceStatusArray[0]=deviceStatus[0]+""+deviceStatus[1];
	  deviceStatusArray[1]=deviceStatus[2]+""+deviceStatus[3];
	  
	 let controllerData=this.data[key];
	  let j=0;
	  for(var key1 in controllerData)
	  {
		  j=j+1;
		  deviceStatusArray
		 roomData["deviceId"+j]=key1;
		 if(deviceStatusArray[0][0]==key1)
		 {
		roomData["deviceStatus"+j]=deviceStatusArray[0][1];	 
		 }
		 else{
			 roomData["deviceStatus"+j]=deviceStatusArray[1][1];	 
		 }
		 
		roomData["deviceName"+j]=controllerData[key1];
	  }
	  rooms [i]=roomData;
	  i=i+1;
    }
	
	console.log(rooms);

	this.roomInfo=rooms;
	localStorage.setItem("roomsData",this.roomInfo);
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
      .setRoot(UpdateControllerPage); 
    
}
schedule(deviceID,roomId,deviceName,roomName)
{
	
	
	let roomData={};
	roomData["controllerID"]=roomId;
	roomData["userID"]="soumyajit0405@gmail.com";
	roomData["deviceID"]=deviceID;
	roomData["deviceName"]=deviceName;
	roomData["roomName"]=roomName;
	 this.store.deviceData = roomData;

	  this.navCtrl.setRoot(SchedulePage);
    
}
  ionViewDidLoad() {
    console.log('ionViewDidLoad DevicesPage');
  }

}
