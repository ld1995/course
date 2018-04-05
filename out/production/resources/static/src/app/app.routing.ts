import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ResultComponent} from './components/search/result/result.component';
import {UserComponent} from './components/user/user.component';
import {RootComponent} from './components/root/root.component';
import {SettingsComponent} from './components/settings/settings.component';
import {AuthGuardService} from './services/auth0/AuthGuardService';

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
    component: UserComponent,// canActivate: [AuthGuardService]
  }
];

export const appRoutingProviders: any[] = [];
export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
