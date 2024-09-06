import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { provideRouter } from '@angular/router';

export const appConfig = {
  providers: [provideRouter([])]
};

bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));

