import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CountryLanguagesComponent } from './components/country-languages/country-languages.component';
import { CountriesComponent } from './components/countries/countries.component';

const routes: Routes = [
  { path: '', redirectTo: 'countries', pathMatch: 'full' },
  { path: 'countries', component: CountriesComponent },
  { path: 'countries/:id/languages', component: CountryLanguagesComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)], // 👈 configure routes
  exports: [RouterModule]                  // 👈 export RouterModule so AppModule can use it
})
export class AppRoutingModule {}
