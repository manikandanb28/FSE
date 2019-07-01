import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-post-add',
  templateUrl: './post-add.component.html',
  styleUrls: ['./post-add.component.css']
})
export class PostAddComponent implements OnInit {

  constructor(private apiService: ApiService, private formBuilder: FormBuilder, private router: Router) { }

  addForm: FormGroup;

  ngOnInit() {
    this.addForm = this.formBuilder.group({
      userId: ['', Validators.min(1)],
      title: ['', Validators.required],
      body: ['', Validators.required],
      id: ['', Validators.min(1)]
    });
  }

  onSubmit(){
    this.apiService.savePost(this.addForm.value).subscribe((response: any)=>{
      console.log("Response:"+response.id);
      localStorage.setItem("userId",response.userId);
      localStorage.setItem("title",response.title);
      localStorage.setItem("body",response.body);
      localStorage.setItem("id",response.id);
      localStorage.setItem("add","add");
      this.router.navigate(['posts']);});
  }
}
