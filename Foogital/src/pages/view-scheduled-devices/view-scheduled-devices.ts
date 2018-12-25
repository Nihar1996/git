import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {ActionService} from "../../providers/action-service";

/**
 * Generated class for the ViewScheduledDevicesPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-view-scheduled-devices',
  templateUrl: 'view-scheduled-devices.html',
})
export class ViewScheduledDevicesPage {

data : any =  
      {
    "response": [
        {
            "controllerId": "C001",
            "time": "22:10",
            "date": "20-10-2018",
            "deviceId": "1",
            "status": "1"
        },
        {
				
            "controllerId": "C005",
            "time": "22:20",
            "date": "20-10-2018",
            "deviceId": "1",
            "status": "1"
        }
    ]
}
;
resposeData : any;
	  scheduleInfo : any;
  constructor(public navCtrl: NavController, public navParams: NavParams,public actionService : ActionService) {
	  
	 this.scheduleInfo=this.data.response;
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ViewScheduledDevicesPage');
  }
delete(roomId,deviceId)
{
	let scheduleDetails={};
	scheduleDetails["controllerID"]=roomId;
	scheduleDetails["userID"]="soumyajit0405@gmail.com";
	scheduleDetails["deviceID"]=deviceId;
	
	 this.actionService.deleteSchedule(scheduleDetails).then((result) =>{
    this.resposeData = result;
    console.log(this.resposeData);
    //if(this.resposeData.response.homeId==1){
     //localStorage.setItem('userData', JSON.stringify(this.resposeData) )
	 console.log("Successfully Logged In");
   // this.navCtrl.push(TabsPage);
   
   
	});
	
}

}
