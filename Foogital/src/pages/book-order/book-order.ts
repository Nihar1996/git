import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

/**
 * Generated class for the BookOrderPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-book-order',
  templateUrl: 'book-order.html',
})
export class BookOrderPage {

  resposeData : any;
  userData = {"type":"","vendorId":"","quantity":"","startTime":"","cost":"","description":""};
  constructor(public navCtrl : NavController, public userservice : UserService, private toastCtrl:ToastController ) {
	  
	 
	
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

  showMenu(){
	  let inputData={};
	  
	  inputData["instituteId"]=localStorage.getItem("instituteId");
	   
   
    this.userservice.showMenu(inputData).then((result) =>{
    this.resposeData = result;
    console.log(this.resposeData);
	 	if(this.resposeData.menu)
	{
		//Show in menu page
    

    }, (err) => {
      //Connection failed message
    });
   
   else{
    this.presentToast("Please provide name");
   }
  });
  }
  
  
  bookOrder(){
	  let inputData={};
	  
	  inputData["foodTxId"]=localStorage.getItem("foodTxId");
	  inputData["userId"]=localStorage.getItem("userId"); 
   
    this.userservice.bookOrder(inputData).then((result) =>{
    this.resposeData = result;
    console.log(this.resposeData);
	 	if(this.resposeData.status==1)
	{
		//Show in confirmation page
    

    }, (err) => {
      //Connection failed message
    });
   
   else{
    this.presentToast("Please provide name");
   }
  });
  }
  
  showCurrentBooking(){
	  let inputData={};
	  
	  
	  inputData["userId"]=localStorage.getItem("userId"); 
   
    this.userservice.showCurrentBooking(inputData).then((result) =>{
    this.resposeData = result;
    console.log(this.resposeData);
	 	if(this.resposeData.status==1)
	{
		//Show in Current Orders page
    

    }, (err) => {
      //Connection failed message
    });
   
   else{
    this.presentToast("Please provide name");
   }
  });
  }
  
  showPreviousBooking(){
	  let inputData={};
	  
	  
	  inputData["userId"]=localStorage.getItem("userId"); 
   
    this.userservice.showCurrentBooking(inputData).then((result) =>{
    this.resposeData = result;
    console.log(this.resposeData);
	 	if(this.resposeData.status==1)
	{
		//Show in Previous Orders page
    

    }, (err) => {
      //Connection failed message
    });
   
   else{
    this.presentToast("Please provide name");
   }
  });
  }
  
  
 

}
