import { Component, ViewChild } from "@angular/core";
import { Platform, Nav } from "ionic-angular";

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { Keyboard } from '@ionic-native/keyboard';

import { HomePage } from "../pages/home/home";
import { LoginPage } from "../pages/login/login";
import { LocalWeatherPage } from "../pages/local-weather/local-weather";
import {AddcontrollerPage} from "../pages/addcontroller/addcontroller";
import {ProfilePage} from "../pages/profile/profile";
import {DevicesPage} from "../pages/devices/devices";
import {ViewScheduledDevicesPage} from "../pages/view-scheduled-devices/view-scheduled-devices";
import {MetricsPage} from "../pages/metrics/metrics";
export interface MenuItem {
    title: string;
    component: any;
    icon: string;
}

@Component({
  templateUrl: 'app.html'
})

export class MyApp {
  @ViewChild(Nav) nav: Nav;

  rootPage: any = LoginPage;

  appMenuItems: Array<MenuItem>;

  constructor(
    public platform: Platform,
    public statusBar: StatusBar,
    public splashScreen: SplashScreen,
    public keyboard: Keyboard
  ) {
    this.initializeApp();

    this.appMenuItems = [
    
      {title: 'Add Controller', component: AddcontrollerPage, icon: 'partly-sunny'},
	  {title: 'My Rooms', component: DevicesPage, icon: 'partly-sunny'},
	  {title: 'My Schedules', component: ViewScheduledDevicesPage, icon: 'partly-sunny'},
	  {title: 'Metrics', component: MetricsPage, icon: 'partly-sunny'}
	  
	  
    ];
  }

  initializeApp() {
    this.platform.ready().then(() => {
      // Okay, so the platform is ready and our plugins are available.

      //*** Control Splash Screen
      // this.splashScreen.show();
      // this.splashScreen.hide();

      //*** Control Status Bar
      this.statusBar.styleDefault();
      this.statusBar.overlaysWebView(false);

      //*** Control Keyboard
    //  this.keyboard.disableScroll(true);
    });
  }

  openPage(page) {
    // Reset the content nav to have just this page
    // we wouldn't want the back button to show in this scenario
	this.nav.setRoot(page.component);
  //  this.nav.setRoot(page.component);
  }

  editProfile() {
    this.nav.setRoot(ProfilePage);
  }
  
  logout()
  {
	  this.nav.setRoot(LoginPage);
  }

}
