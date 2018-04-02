import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {ResultComponent} from "./components/search/result/result.component";
import {UserComponent} from "./components/user/user.component";
import {WorkbookListComponent} from "./components/workbook-list/workbook-list.component";
import {RootComponent} from "./components/root/root.component";
import {SettingsComponent} from "./components/settings/settings.component";
import {Workbook} from "./models/workbook.model";


const appRoutes: Routes = [
  {
    path: '',
    component: RootComponent
  }, {
    path: 'result',
    component: ResultComponent
  }, {
    path: 'settings',
    component: SettingsComponent,
  }, {
    path: 'user',
    component: UserComponent
  }
];

export const appRoutingProviders: any[] = [];
export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
