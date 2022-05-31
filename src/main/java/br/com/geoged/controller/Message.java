package br.com.geoged.controller;

public class Message
{
	private String name;
   private String content;


   public Message() {}

   public Message(String name) {
       this.name = name;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }
   


   public String getContent() {
       return content;
   }
}
