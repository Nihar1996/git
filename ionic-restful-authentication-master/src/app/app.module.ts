import { NgModule, ErrorHandler } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';
import { AuthServiceCustom } from '../providers/auth-service';
import { SplitPane } from '../providers/split-pane';
import { Common } from '../providers/common';
import { HttpModule } from "@angular/http";
import { Welcome } from '../pages/welcome/welcome';
import { Login } from '../pages/login/login';
import { Signup } from '../pages/signup/signup';
import { ForgotPasswordPage } from '../pages/forgot-password/forgot-password';
import { AboutPage } from '../pages/about/about';
import { ContactPage } from '../pages/contact/contact';
import { HomePage } from '../pages/home/home';
import { TabsPage } from '../pages/tabs/tabs';
import {MenuPage} from "../pages/home-1/home-1";
import {DevicesPage} from "../pages/devices/devices";
import {ProfilePage} from "../pages/profile/profile";
import {TabsPageModule} from "../pages/tabs/tabs.module";
import {ProfilePageModule} from "../pages/profile/profile.module";
import {DevicesPageModule} from "../pages/devices/devices.module";
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { MomentModule } from 'angular2-moment';
import { LinkyModule } from 'angular-linky';
    import {
    SocialLoginModule,
    AuthServiceConfig,
    GoogleLoginProvider,
    
} from "angular-6-social-login";

export function getAuthServiceConfigs() {
  let config = new AuthServiceConfig(
      [
        
        {
          id: GoogleLoginProvider.PROVIDER_ID,
          provider: new GoogleLoginProvider("910042342275-aqo86ppoe4eslo1kbnh2ck6erpihqtrt.apps.googleusercontent.com")
        }
      ]
  );
  return config;
}

@NgModule({
  declarations: [
    MyApp,
    Welcome,
    Login,
    Signup,
	ForgotPasswordPage,
    AboutPage,
    ContactPage,
    HomePage,

	MenuPage,
	
  ],
  imports: [
    BrowserModule,HttpModule,MomentModule,LinkyModule,
    IonicModule.forRoot(MyApp),SocialLoginModule,
	TabsPageModule,ProfilePageModule,
	DevicesPageModule
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    Welcome,
    Login,
    Signup,
	ForgotPasswordPage,
    AboutPage,
    ContactPage,
    HomePage,
    TabsPage,
	MenuPage,
	ProfilePage,
	DevicesPage
  ],
  providers: [
    StatusBar,
    SplashScreen,AuthServiceCustom,SplitPane,Common,{provide:AuthServiceConfig,
	useFactory: getAuthServiceConfigs},
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
