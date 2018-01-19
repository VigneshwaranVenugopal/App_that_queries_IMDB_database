CREATE TABLE Movie(
M_id varchar2(5) PRIMARY KEY,
M_Title varchar2(150),
Imdb_id varchar2(8),
M_Spanish_Title varchar2(100),
Imdb_Pic_Url varchar2(200),
M_Year varchar2(10),
Rotten_id varchar2(100),
Rt_All_Critics_Ratings varchar2(40),
Rt_All_Critics_Num_Reviews varchar2(50),
Rt_All_Critics_Num_Fresh varchar2(50),
Rt_All_Critics_Num_Rotten varchar2(50),
Rt_All_Critics_Score varchar2(50),
Rt_Top_Critics_Ratings varchar2(50),
Rt_Top_Critics_Num_Reviews varchar2(50),
Rt_Top_Critics_Num_Fresh varchar2(50),
Rt_Top_Critics_Num_Rotten varchar2(50),
Rt_Top_Critics_Score varchar2(50),
Rt_Audience_Rating varchar2(50),
Rt_Audience_Num_Ratings varchar2(50),
Rt_Audience_Score varchar2(50),
Rt_Picture_Url varchar2(200)
);

CREATE TABLE Movie_Genres(
M_id varchar2(5),
Genre varchar2(20),
FOREIGN KEY (M_id) REFERENCES Movie(M_id) ON DELETE CASCADE
);
  

CREATE TABLE Movie_Countries(
M_id varchar2(5) PRIMARY KEY,
Country varchar2(35),
FOREIGN KEY(M_id) REFERENCES Movie(M_id) ON DELETE CASCADE
);

 
CREATE TABLE Movie_Locations(
M_id varchar2(5),
Location_Country varchar2(50),
Location_State varchar2(50),
Location_City varchar2(70),
Location_Street varchar2(140),
FOREIGN KEY(M_id) REFERENCES Movie(M_id) ON DELETE CASCADE
);


CREATE TABLE Tags(
Tag_id varchar2(20) PRIMARY KEY,
Tag_Text varchar2(50)
);


CREATE TABLE Movie_Tags(
M_id varchar2(20),
Tag_id varchar2(20),
Tag_Weight varchar2(20),
FOREIGN KEY(M_id) REFERENCES Movie(M_id)ON DELETE CASCADE,
FOREIGN KEY(Tag_id) REFERENCES Tags(Tag_id) ON DELETE CASCADE
);

CREATE INDEX GenreIndex ON Movie_Genres(Genre);

CREATE INDEX CountryIndex ON Movie_Countries(Country);

CREATE INDEX FilmLocIndex ON Movie_Locations(Location_Country);













