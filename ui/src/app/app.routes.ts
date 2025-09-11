import { Routes } from '@angular/router';
import { CountriesComponent } from './components/countries/countries.component';
import { CountryLanguagesComponent } from './components/country-languages/country-languages.component';
import { HomeComponent } from './components/home/home.component';

export const ROUTES: Routes = [
  { path: '', component: HomeComponent }, // Home is the default
  { path: 'countries', component: CountriesComponent },
  { path: 'countries/:id/languages', component: CountryLanguagesComponent },
  // { path: 'task2', loadComponent: () => import('./components/task2/task2.component').then(m => m.Task2Component) },
  // { path: 'task3', loadComponent: () => import('./components/task3/task3.component').then(m => m.Task3Component) },
  
];