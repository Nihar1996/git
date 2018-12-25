import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ViewScheduledDevicesPage } from './view-scheduled-devices';

@NgModule({
  declarations: [
    ViewScheduledDevicesPage,
  ],
  imports: [
    IonicPageModule.forChild(ViewScheduledDevicesPage),
  ],
})
export class ViewScheduledDevicesPageModule {}
