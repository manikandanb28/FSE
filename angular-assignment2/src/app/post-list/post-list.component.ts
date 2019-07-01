import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {
  private posts: Array<Object> = [];
  constructor(private apiService: ApiService, private router: Router) { }

  ngOnInit() {
    this.getPostList();
  }

  public getPostList(){
    this.apiService.getPostList().subscribe((data: Array<Object>)=>{
      this.posts = data;
      this.getAddStorageData(this.posts);
     
      console.log("Data:"+data.length);
    })
  }

  removePost(id){
    console.log("Id:"+id);
    this.apiService.deletePost(id).subscribe((data: any)=>{this.posts = this.posts.filter((a: any)=>a.id!=id)});
  }

  editPost(id){
    console.log("id:"+id);
    this.clearAddStorage();
    localStorage.removeItem("editId");
    localStorage.setItem("editId", id);
    this.router.navigate(['edit-post']);
  }

  addPost(){
    this.clearAddStorage();
    this.router.navigate(['add-post']);
  }

  clearAddStorage(){
    localStorage.removeItem("userId");
    localStorage.removeItem("title");
    localStorage.removeItem("body");
    localStorage.removeItem("id");
    localStorage.removeItem("add");
    localStorage.removeItem("edit");
  }

  getAddStorageData(postList){
    let add = localStorage.getItem("add");
    let edit = localStorage.getItem("edit");

    if(edit){
      console.log("Edit:"+edit);
      let tempPosts: Array<Object> = [];
      let id = localStorage.getItem("id");
      tempPosts = postList;
      let index = tempPosts.findIndex((t:any)=>t.id==id);

      console.log("Index:"+index);

      tempPosts.splice(index,1,this.generateElement());
      postList = tempPosts;
      this.clearAddStorage();
    } else {
      if(add) {
        
        console.log("Add:"+add);
    
        postList.push(this.generateElement());
    
        this.clearAddStorage();
      } else{
        console.log("No data in localStorage");
      }
    }
    
  }

  generateElement(){
    let title = localStorage.getItem("title");
    let body = localStorage.getItem("body");
    let userId = localStorage.getItem("userId");
    let id = localStorage.getItem("id");
    
    let postTemp: any = ({"userId":userId, "title":title, "body":body, "id":id});

    return postTemp;
  }
}
