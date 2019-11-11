import { UrlDetailsComponent } from './url-details/url-details.component';
import { CreateUrlComponent } from './create-url/create-url.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UrlListComponent } from './url-list/url-list.component';
import { UpdateUrlComponent } from './update-url/update-url.component';

const routes: Routes = [
  { path: '', redirectTo: 'url', pathMatch: 'full' },
  { path: 'urls', component: UrlListComponent },
  { path: 'add', component: CreateUrlComponent },
  { path: 'update/:id', component: UpdateUrlComponent },
  { path: 'details/:id', component: UrlDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
