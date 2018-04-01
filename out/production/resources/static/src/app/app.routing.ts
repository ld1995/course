import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {ResultComponent} from "./components/search/result/result.component";


const appRoutes: Routes = [
  {
    path: 'home',
    component: HomeComponent
  }, {
    path: 'result',
    component : ResultComponent
  }
];

export const appRoutingProviders: any[] = [];
export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
// const routes: Routes = [
//   Route.withShell([
//     { path: 'page', component: ConspectsComponent, data: { title: extract('Personal Page') } }
//   ])
// ];
