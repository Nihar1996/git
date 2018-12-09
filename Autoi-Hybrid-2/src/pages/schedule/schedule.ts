import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {StoreService} from "../../providers/store-service";
//import {AuthServiceCustom} from "../../providers/auth-service";
/**
 * Generated class for the SchedulePage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-schedule',
  templateUrl: 'schedule.html',
})
export class SchedulePage {
 resposeData : any;

 scheduleData = {"cid":"", "pkey":"","rname":"","did":"","dname":"","time":""};
  constructor(public navCtrl: NavController, public navParams: NavParams,public store: StoreService) {
	    console.log("Data from devices page"+this.store.deviceData.name)
	  this.scheduleData.rname=this.store.deviceData.roomName;
	  this.scheduleData.dname=this.store.deviceData.deviceName;
	
	
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad SchedulePage');
  }
   schedule()
  {
	/*  this.actionService.scheduleDevice(deviceId).then((result) =>{
    this.resposeData = result;
    console.log(this.resposeData);
    //if(this.resposeData.response.homeId==1){
     //localStorage.setItem('userData', JSON.stringify(this.resposeData) )
	 console.log("Successfully Logged In");
   // this.navCtrl.push(TabsPage);
   
   
	}); */
	 }
 
}
