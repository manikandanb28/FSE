import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {first} from "rxjs/operators";

@Component({
  selector: 'app-post-edit',
  templateUrl: './post-edit.component.html',
  styleUrls: ['./post-edit.component.css']
})
export class PostEditComponent implements OnInit {
  
  constructor(private apiService: ApiService, private formBuilder: FormBuilder, private router: Router) { }
  editForm: FormGroup;
  ngOnInit() {
    let id = localStorage.getItem("editId");

    if(!id){
      alert("Invalid action.")
      this.router.navigate(['posts']);
      return;
    }

    this.apiService.findPostById(id).subscribe((data:any)=>{
      this.editForm.setValue(data);
    });

    this.editForm = this.formBuilder.group({
      id: ['', Validators.min(1)],
      title: ['', Validators.nullValidator],
      body: ['', Validators.min(0)],
      userId: ['', Validators.min(0)]
    });
  }

  onSubmit(){
    this.apiService.updatePost(this.editForm.value)
    .pipe(first())
    .subscribe((response: any)=>{
      console.log("Response:"+response.id);
      localStorage.setItem("userId",response.userId);
      localStorage.setItem("title",response.title);
      localStorage.setItem("body",response.body);
      localStorage.setItem("id",response.id);
      localStorage.setItem("edit","edit");
      this.router.navigate(['posts'])},
    error=>alert(error));
  }

}
