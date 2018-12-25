import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

/**
 * Generated class for the AddMenuPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-add-menu',
  templateUrl: 'add-menu.html',
})
export class AddMenuPage {

 resposeData : any;
  userData = {"type":"","vendorId":"","quantity":"","startTime":"","cost":"","description":""};
  constructor(public navCtrl : NavController, public vendorService : VendorService, private toastCtrl:ToastController ) {
	  
	  let inputData={};
	  inputData["type"]=localStorage.getItem("test");
	  //vendor 
	   this.vendorService.getFoodType(inputData).then((result) =>{
    this.resposeData = result;
    console.log(this.resposeData);
	if(this.resposeData)
	{
	//assign the list to dropdown
	
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

  addFood(){
	  let inputData={};
	  
	  inputData["type"]=this.userData.type;
	  inputData["vendorId"]=localStorage.getItem("vendorId");
	  inputData["quantity"]=localStorage.getItem("quantity");
	  inputData["startTime"]=localStorage.getItem("startTime");
	  inputData["endTime"]=localStorage.getItem("endTime");
	  inputData["cost"]=localStorage.getItem("cost");
	  	  inputData["description"]=localStorage.getItem("description");
	   
   if(this.userData.name){
    this.vendorService.addFood(inputData).then((result) =>{
    this.resposeData = result;
    console.log(this.resposeData);
	 	if(this.resposeData.status==1)
	{
		localStorage.setItem("foodTxId",resposeData.foodTxId);
	 let toast = this.toastCtrl.create({
              message: 'Added Succesfully',
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
  
    showMenu(){
	  let inputData={};
	  
	  inputData["phone"]=this.userData.phone;
	  inputData["name"]=this.userData.name;
	   
   if(this.userData.name){
    this.vendorService.showMenu(inputData).then((result) =>{
    this.resposeData = result;
	//Show Menu in navigation
    	
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
