package com.domain;

import java.io.Serializable;

/**
 * 客房实体类
 */
public class Hostel implements Serializable {
        private int id;
        private String hostelName;
        private String hostelImage;
        private float hostelPrice;
        private String hostelSketch;
        private int hostelStatus;
        private String cname;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getHostelName() {
                return hostelName;
        }

        public void setHostelName(String hostelName) {
                this.hostelName = hostelName;
        }

        public String getHostelImage() {
                return hostelImage;
        }

        public void setHostelImage(String hostelImage) {
                this.hostelImage = hostelImage;
        }

        public float getHostelPrice() {
                return hostelPrice;
        }

        public void setHostelPrice(float hostelPrice) {
                this.hostelPrice = hostelPrice;
        }

        public String getHostelSketch() {
                return hostelSketch;
        }

        public void setHostelSketch(String hostelSketch) {
                this.hostelSketch = hostelSketch;
        }

        public int getHostelStatus() {
                return hostelStatus;
        }

        public void setHostelStatus(int hostelStatus) {
                this.hostelStatus = hostelStatus;
        }

        public String getCname() {
                return cname;
        }

        public void setCname(String cname) {
                this.cname = cname;
        }

        @Override
        public String toString() {
                return "Hostel{" +
                        "id=" + id +
                        ", hostelName='" + hostelName + '\'' +
                        ", hostelImage='" + hostelImage + '\'' +
                        ", hostelPrice=" + hostelPrice +
                        ", hostelSketch='" + hostelSketch + '\'' +
                        ", hostelStatus=" + hostelStatus +
                        ", cname='" + cname + '\'' +
                        '}';
        }
}
