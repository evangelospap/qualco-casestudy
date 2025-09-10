import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { provideRouter } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { ROUTES } from './app/app-routing.module';
import { importProvidersFrom } from '@angular/core';

bootstrapApplication(AppComponent, {
  providers: [
    provideRouter(ROUTES),
    importProvidersFrom(HttpClientModule)
  ]
}).catch(err => console.error(err));
