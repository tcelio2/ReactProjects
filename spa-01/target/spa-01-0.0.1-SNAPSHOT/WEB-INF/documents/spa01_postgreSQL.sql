-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2016-06-23 19:53:52.247

-- tables
-- Table: dashboard
CREATE TABLE dashboard (
    project_id serial  NOT NULL,
    application int  NOT NULL,
    
	project_name varchar(256),
    project_state varchar(20),
    sdlc varchar(120),
    project_status varchar(20),
    comments varchar(120),
    jeopardy_list varchar(1),
	
	--project information
    pi_ftps varchar(20),
    pi_ftps_currentmonth varchar(20),
    pi_ftps_nextmonth varchar(20),
    pi_crs varchar(20),
    pi_se varchar(20),
    pi_ibmpm varchar(50),
    pi_apm varchar(120),
	--schedule
    sc_release varchar(20),
    sc_testingtarget varchar(20),
    sc_sprint varchar(20),
    sc_schedule varchar(100),
	
	--Impact
    i_type varchar(20),
    i_tube varchar(20),
    i_bc varchar(20),
    i_inv varchar(20),
    i_pi varchar(20),
	
	--development
   dev_utd varchar(16),
   
   dev_utd_tube varchar(16),
   dev_utd_tube_resource varchar(16),
   dev_utd_tube_due_date varchar(16),
   dev_utd_tube_planned varchar(16),
   
   dev_utd_bc varchar(16),
   dev_utd_bc_resource varchar(16),
   dev_utd_bc_due_date varchar(16),
   dev_utd_bc_planned varchar(16),
   
   dev_utd_inv varchar(16),
   dev_utd_inv_resource varchar(16),
   dev_utd_inv_due_date varchar(16),
   dev_utd_inv_planned varchar(16),
   
   dev_std varchar(16),
   
   dev_std_stsr varchar(256),
   dev_std_stsr_resource varchar(128),
   dev_std_stsr_due_date varchar(16),
   dev_std_stsr_planned varchar(16),
   
   dev_std_testdata varchar(256),
   dev_std_testdata_resource varchar(256),
   dev_std_testdata_resource_due_date varchar(256),
   dev_std_testdata_planned varchar(256),
   
   dev_tap varchar(16),
   
   dev_tap_pi varchar(16),
   dev_tap_pi_resource varchar(128),
   dev_tap_pi_due_date varchar(16),
   dev_tap_pi_planned varchar(16),
   
   dev_code varchar(16),
   
   dev_code_tube varchar(16),
   dev_code_tube_resource varchar(128),
   dev_code_tube_due_date varchar(16),
   dev_code_tube_planned varchar(16),
   
   dev_code_bc varchar(16),
   dev_code_bc_resource varchar(128),
   dev_code_bc_due_date varchar(16),
   dev_code_bc_planned varchar(16),
   
   dev_code_inv varchar(16),
   dev_code_inv_resource varchar(128),
   dev_code_inv_due_date varchar(16),
   dev_code_inv_planned varchar(16),
   
   dev_ut varchar(16),
   dev_ut_tube varchar(16),
   dev_ut_tube_resource varchar(128),
   dev_ut_tube_due_date varchar(16),
   dev_ut_tube_planned varchar(16),
   
   dev_ut_bc varchar(16),
   dev_ut_bc_resource varchar(128),
   dev_ut_bc_due_date varchar(16),
   dev_ut_bc_planned varchar(16),
   
   dev_ut_inv varchar(16),
   dev_ut_inv_resource varchar(128),
   dev_ut_inv_due_date varchar(16),
   dev_ut_inv_planned varchar(16),
   
   --end of dev
   
   -- design
   
   des_hld varchar(16),
   
   des_hld_tube varchar(16),
   des_hld_tube_resource varchar(128),
   des_hld_tube_due_date varchar(16),
   des_hld_tube_planned varchar(16),
   
   des_hld_bc varchar(16),
   des_hld_bc_resource varchar(128),
   des_hld_bc_due_date varchar(16),
   des_hld_bc_planned varchar(16),
   
   des_hld_inv varchar(16),
   des_hld_inv_resource varchar(128),
   des_hld_inv_due_date varchar(16),
   des_hld_inv_planned varchar(16),
   
   des_hld_pi varchar(16),
   des_hld_pi_resource varchar(128),
   des_hld_pi_due_date varchar(16),
   des_hld_pi_planned varchar(16),
   
   des_ia varchar(16),
   des_ia_ia varchar(16),
   des_ia_ia_resource varchar(128),
   des_ia_ia_due_date varchar(16),
   des_ia_ia_planned varchar(16),
   
   des_ad varchar(16),
   
   des_ad_tube varchar(16),
   des_ad_tube_resource varchar(128),
   des_ad_tube_due_date varchar(16),
   des_ad_tube_planned varchar(16),
   
   des_ad_bc varchar(16),
   des_ad_bc_resource varchar(256),
   des_ad_bc_due_date varchar(16),
   des_ad_bc_planned varchar(16),
   
   des_ad_inv varchar(16),
   des_ad_inv_resource varchar(128),
   des_ad_inv_due_date varchar(16),
   des_ad_inv_planned varchar(16),
   
   
   des_cw varchar(16),
   des_cw_pi varchar(16),
   des_cw_pi_resource varchar(128),
   des_cw_pi_due_date varchar(16),
   des_cw_pi_planned varchar(16),
   --end of design
	
	-- requirement
   req_srs varchar(16),
   req_srs_status varchar(16),
   req_srs_base_line_date varchar(16),
   req_srs_due_date varchar(16),
   req_srs_planned varchar(16),
   --end of requirement
	
    user_project_id int  NOT NULL,
    deliverable_id int  NOT NULL,
    CONSTRAINT dashboard_pk PRIMARY KEY (project_id)
);

-- Table: deliverable
CREATE TABLE deliverable (
    id serial  NOT NULL,
    description varchar(256)  NOT NULL,
    title varchar(64)  NOT NULL,
    hld int  NOT NULL,
    ia int  NOT NULL,
    ad int  NOT NULL,
    cw int  NOT NULL,
    CONSTRAINT deliverable_pk PRIMARY KEY (id)
);

-- Table: schedule
CREATE TABLE schedule (
    id serial  NOT NULL,
    deliverable_id int  NOT NULL,
    hld_start_date date  NOT NULL,
    hld_end_date date  NOT NULL,
    ia_start_date date  NOT NULL,
    ia_end_date date  NOT NULL,
    ad_start_date date  NOT NULL,
    ad_end_date date  NOT NULL,
    cw_start_date date  NOT NULL,
    cw_end_date date  NOT NULL,
    dashboard_project_id int  NOT NULL,
    CONSTRAINT schedule_pk PRIMARY KEY (id)
);

-- Table: user_project
CREATE TABLE user_project (
    name varchar(128)  NOT NULL,
    id serial  NOT NULL,
    email varchar(64)  NOT NULL,
    password varchar(64)  NOT NULL,
    last_name varchar(64)  NOT NULL,
    CONSTRAINT id PRIMARY KEY (id)
);


-- Table: user_roles
CREATE TABLE user_role (
    id_role serial  NOT NULL,
    role_name varchar(64)  NOT NULL,
    CONSTRAINT id_role_pk PRIMARY KEY (id_role)
);



-- foreign keys
-- Reference: dashboard_deliverable (table: dashboard)
ALTER TABLE dashboard ADD CONSTRAINT dashboard_deliverable
    FOREIGN KEY (deliverable_id)
    REFERENCES deliverable (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: dashboard_deliverable (table: dashboard)
ALTER TABLE user_project ADD CONSTRAINT user_project_role
    FOREIGN KEY (role_id)
    REFERENCES user_role (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: project_user_project (table: dashboard)
ALTER TABLE dashboard ADD CONSTRAINT project_user_project
    FOREIGN KEY (user_project_id)
    REFERENCES user_project (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: schedule_dashboard (table: schedule)
ALTER TABLE schedule ADD CONSTRAINT schedule_dashboard
    FOREIGN KEY (dashboard_project_id)
    REFERENCES dashboard (project_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: schedule_deliverable (table: schedule)
ALTER TABLE schedule ADD CONSTRAINT schedule_deliverable
    FOREIGN KEY (deliverable_id)
    REFERENCES deliverable (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

