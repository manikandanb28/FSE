import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PostAddComponent } from './post-add/post-add.component';
import { PostListComponent } from './post-list/post-list.component';
import { PostEditComponent } from './post-edit/post-edit.component';

const routes: Routes = [
    {path:'', redirectTo:'posts', pathMatch: 'full'},
    {path: 'posts', component: PostListComponent},
    {path: 'add-post', component: PostAddComponent},
    {path: 'edit-post', component: PostEditComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule{

}