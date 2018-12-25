import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { BookOrderPage } from './book-order';

@NgModule({
  declarations: [
    BookOrderPage,
  ],
  imports: [
    IonicPageModule.forChild(BookOrderPage),
  ],
})
export class BookOrderPageModule {}
