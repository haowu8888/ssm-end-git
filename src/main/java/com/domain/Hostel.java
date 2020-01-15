package com.domain;

/**
 * 客房实体类
 */
public class Hostel {
        private int id;
        private int hid;
        private String hostelName;
        private String hostelImage;
        private float hostelPrice;
        private String hostelSketch;
        private int hostelStatus;
        private int cid;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public int getHid() {
                return hid;
        }

        public void setHid(int hid) {
                this.hid = hid;
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

        public int getCid() {
                return cid;
        }

        public void setCid(int cid) {
                this.cid = cid;
        }

        @Override
        public String toString() {
                return "Hostel{" +
                        "id=" + id +
                        ", hid=" + hid +
                        ", hostelName='" + hostelName + '\'' +
                        ", hostelImage='" + hostelImage + '\'' +
                        ", hostelPrice=" + hostelPrice +
                        ", hostelSketch='" + hostelSketch + '\'' +
                        ", hostelStatus=" + hostelStatus +
                        ", cid=" + cid +
                        '}';
        }
}
