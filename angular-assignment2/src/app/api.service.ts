import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  API_URL = 'https://jsonplaceholder.typicode.com';
  constructor(private httpClient: HttpClient) { }

  getPostList(){
    return this.httpClient.get(`${this.API_URL}/posts`);
  }

  savePost(post){
    return this.httpClient.post(`${this.API_URL}/posts`,post);
  }

  deletePost(id){
    return this.httpClient.delete(`${this.API_URL}/posts/${id}`)
  }

  updatePost(post){
    return this.httpClient.put(`${this.API_URL}/posts/${post.id}`, post);
  }

  findPostById(id){
    return this.httpClient.get(`${this.API_URL}/posts/${id}`);
  }
}
