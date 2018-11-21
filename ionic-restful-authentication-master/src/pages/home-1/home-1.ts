import { Component, ViewChild } from '@angular/core';
import { NavController, Nav } from 'ionic-angular';
 
@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class MenuPage {
  @ViewChild(Nav) nav: Nav;
  pages: Array<{title: string, component: any, openTab? : any}>;
  rootPage = 'DashboardTabsPage';
 
  constructor(public navCtrl: NavController) {
    this.pages = [
      { title: 'Dashboard', component: 'DashboardTabsPage' },
      { title: 'My Lists', component: 'ListsTabsPage' },
      { title: 'Direkt Profile Link', component: 'DashboardTabsPage', openTab: 1 },
      { title: 'No Tabs Link', component: 'NoTabsPage' },
    ];
  }
 
  openPage(page) {
    this.nav.setRoot(page.component, { openTab: page.openTab });
  }
}