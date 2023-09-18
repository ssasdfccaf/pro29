package com.myspring.pro29.ex03.csy0918;

import java.lang.reflect.Member;

public class memberVO3 implements Member {
		private String id;
		private String pwd;
		private String name;
		private String email;
		
		public void MemberVO3() {
			
		}
		public String getId() {
			return id;
		}
		public void setId(String string) {
			this.id = id;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		@Override
		public String toString() {
			String info = id+", "+ pwd+", "+ name+", "+ email; 
			return info;
		}
		public void setId(Integer memberVO3) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public Class<?> getDeclaringClass() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public int getModifiers() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public boolean isSynthetic() {
			// TODO Auto-generated method stub
			return false;
		}

	}
