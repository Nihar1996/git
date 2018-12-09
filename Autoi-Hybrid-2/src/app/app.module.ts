import {NgModule} from "@angular/core";
import {IonicApp, IonicModule} from "ionic-angular";
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import {IonicStorageModule} from '@ionic/storage';
import { AuthServiceCustom } from '../providers/auth-service';
import { AccountService } from '../providers/account-service';
import { ActionService } from '../providers/action-service';
import {StoreService} from "../providers/store-service";
import {StatusBar} from '@ionic-native/status-bar';
import {SplashScreen} from '@ionic-native/splash-screen';
import {Keyboard} from '@ionic-native/keyboard';

import {ActivityService} from "../services/activity-service";
import {TripService} from "../services/trip-service";
import {WeatherProvider} from "../services/weather";

import {MyApp} from "./app.component";

import {SettingsPage} from "../pages/settings/settings";
import {CheckoutTripPage} from "../pages/checkout-trip/checkout-trip";
import {HomePage} from "../pages/home/home";
import {LoginPage} from "../pages/login/login";
import {NotificationsPage} from "../pages/notifications/notifications";
import {RegisterPage} from "../pages/register/register";
import {SearchLocationPage} from "../pages/search-location/search-location";
import {TripDetailPage} from "../pages/trip-detail/trip-detail";
import {TripsPage} from "../pages/trips/trips";
import {LocalWeatherPage} from "../pages/local-weather/local-weather";
import {AddcontrollerPage} from "../pages/addcontroller/addcontroller";
import {ProfilePage} from "../pages/profile/profile";
import {ChangepasswordPage} from "../pages/changepassword/changepassword";
import {DevicesPage} from "../pages/devices/devices";
import {UpdateControllerPage} from "../pages/update-controller/update-controller";
import {ViewScheduledDevicesPage} from "../pages/view-scheduled-devices/view-scheduled-devices";
import {SchedulePage} from "../pages/schedule/schedule";
import {MetricsPage} from "../pages/metrics/metrics";

import { ChartsModule } from 'ng2-charts';

import { HttpModule } from '@angular/http';

// import services
// end import services
// end import services

// import pages
// end import pages

@NgModule({
  declarations: [
    MyApp,
    SettingsPage,
    CheckoutTripPage,
    HomePage,
    LoginPage,
    LocalWeatherPage,
    NotificationsPage,
    RegisterPage,
    SearchLocationPage,
    TripDetailPage,
    TripsPage,
	AddcontrollerPage,
	ProfilePage,
	ChangepasswordPage,
	DevicesPage,
	UpdateControllerPage,
	ViewScheduledDevicesPage,
	SchedulePage,
	MetricsPage
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
	HttpModule,
	ChartsModule,
    IonicModule.forRoot(MyApp, {
      scrollPadding: false,
      scrollAssist: true,
      autoFocusAssist: false
    }),
    IonicStorageModule.forRoot({
      name: '__ionic3_start_theme',
        driverOrder: ['indexeddb', 'sqlite', 'websql']
    })
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    SettingsPage,
    CheckoutTripPage,
    HomePage,
    LoginPage,
    LocalWeatherPage,
    NotificationsPage,
    RegisterPage,
    SearchLocationPage,
    TripDetailPage,
    TripsPage,
	AddcontrollerPage,
	ProfilePage,
	ChangepasswordPage,
	DevicesPage,
	UpdateControllerPage,
	ViewScheduledDevicesPage,
	SchedulePage,
	MetricsPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    Keyboard,
    ActivityService,
    TripService,
    WeatherProvider,
	AuthServiceCustom,AccountService,ActionService,StoreService
  ]
})

export class AppModule {
}
