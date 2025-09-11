import { Routes } from '@angular/router';
import { CountriesComponent } from './components/countries/countries.component';
import { CountryLanguagesComponent } from './components/country-languages/country-languages.component';
import { HomeComponent } from './components/home/home.component';
import { CountryStatsComponent } from './components/country-stats/country-stats.component';
import { CountryDataComponent } from './components/country-data/country-data.component';

export const ROUTES: Routes = [
  // Redirect empty path to 'home'
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  // The actual HomeComponent mapped to 'home'
  { path: 'home', component: HomeComponent },
  { path: 'countries', component: CountriesComponent },
  { path: 'countries/:id/languages', component: CountryLanguagesComponent },
  { path: 'countries/stats', component: CountryStatsComponent },
  { path: 'country-data', component: CountryDataComponent }
  
];