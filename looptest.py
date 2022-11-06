import pandas as pd
import openpyxl #패키지 불러오기
from selenium import webdriver
from selenium.webdriver.common.by import By
import time
import firebase_admin
from firebase_admin import credentials
from firebase_admin import db
from pickle import TRUE
from threading import Thread
import time
import firebase_admin
from firebase_admin import credentials
from firebase_admin import db, storage,firestore
import sys
import requests
import numpy as np
import cv2 as cv
import glob
from sklearn.cluster import KMeans
import random as rng
import cv2
import imutils
import argparse
from imutils import contours
from skimage.io import imread
import numpy as np
import matplotlib.pyplot as plt
import os
import glob
from utils import *
footlevel = ''
 #for test
dates = 11
cred = credentials.Certificate('mykey.json')
firebase_admin.initialize_app(cred,{
    'databaseURL':'https://graduate-project-3c7b4-default-rtdb.firebaseio.com/',
    'storageBucket':'graduate-project-3c7b4.appspot.com'
})






#축구화 상품 목록 생성
filename = '축구화 데이터.xlsx'
book = openpyxl.load_workbook(filename)
df = pd.read_excel(filename)
#print(df)
sheet=book.worksheets[0]
data = [] #리스트 자료형 생성
for row in sheet.rows: #전체 행에 대하여 반복실행

        data.append([
            row[0].value, #1열 데이터
            row[1].value, #2열 데이터
            row[2].value, #3열 데이터
            row[3].value, #4열 데이터
            row[4].value, #5열 데이터
            row[5].value,  #6열 데이터
            row[6].value,  #7열 데이터
            row[7].value,  #8열 데이터
            row[8].value,
            row[9].value

    ])
del data[0]
football_list=[]
for i in data:
    if i[0]=='브랜드':
        continue
    a = i[0]+' '+i[1]+' '+str(i[2])
    football_list.append(a)

#브랜드별 축구화 리스트
adidas_list=[]
mizuno_list=[]
puma_list=[]
nike_list=[]
for i in range(len(data)):
    if 0<=i<68:
        adidas_list.append(football_list[i])
    elif 68<=i<78:
        mizuno_list.append(football_list[i])
    elif 78<=i<99:
        puma_list.append(football_list[i])
    else:
        nike_list.append(football_list[i])





#축구화 가격표
football_price=[]
for i in data:
    if i[0]=='브랜드':
        continue
    b=i[3]
    football_price.append(b)


bucket = storage.bucket()



ref=db.reference('/')
users_ref =  ref.child('cnt')
users_ref1 = ref.child('축구화 브랜드')
users_ref2 = ref.child('추천 결과')

users_ref3 = ref.child('설문조사')

ref.update({'cnt':0});
#
while True:
    if users_ref.get()==0:
        time.sleep(3)
        print("대기")
    else:
       # lp2.start()
       i = users_ref.get()


       blb1 = bucket.get_blob('myimages/feet.jpg')
       blb1.download_to_filename("data/testpicture{}.jpg".format(i))
       ImgPath = 'data/testpicture{}.jpg'.format(i)
       oimg = imread(ImgPath)  # 회색으로 이미지를 불러온다.

       if not os.path.exists('output'):
           os.makedirs('output')

       preprocessedOimg = preprocess(oimg)  # preprocess로 이미지를 정형화해준다.
       cv2.imwrite('output/preprocessedOimg.jpg', preprocessedOimg)

       clusteredImg = kMeans_cluster(preprocessedOimg)
       cv2.imwrite('output/clusteredImg.jpg', clusteredImg)

       edgedImg = edgeDetection(clusteredImg)
       cv2.imwrite('output/edgedImg.jpg', edgedImg)

       boundRect, contours, contours_poly, img = getBoundingBox(edgedImg)
       pdraw = drawCnt(boundRect[1], contours, contours_poly, img)
       cv2.imwrite('output/pdraw.jpg', pdraw)

       croppedImg, pcropedImg = cropOrig(boundRect[1], clusteredImg)
       cv2.imwrite('output/croppedImg.jpg', croppedImg)

       newImg = overlayImage(croppedImg, pcropedImg)
       cv2.imwrite('output/newImg.jpg', newImg)

       fedged = edgeDetection(newImg)
       fboundRect, fcnt, fcntpoly, fimg = getBoundingBox(fedged)
       fdraw = drawCnt(fboundRect[2], fcnt, fcntpoly, fimg)
       cv2.imwrite('output/fdraw.jpg', fdraw)
       footwidth, footlength = calcFeetSize(pcropedImg, fboundRect)

       print("발 사이즈 (mm): ", footwidth, footlength)
#+7+10
       # 200사이즈
       if footlength <= 200:
           if footwidth <= 98:
               footlevel = 'A'
           elif 98 < footwidth <= 102:
               footlevel = 'B'
           elif 102 < footwidth <= 106:
               footlevel = 'C'
           elif 106 < footwidth <= 110:
               footlevel = 'D'
           elif 110 < footwidth:
               footlevel = 'E'
           # 205사이즈
       elif 200 < footlength <= 205:
           if footwidth <= 100:
               footlevel = 'A'
           elif 100 < footwidth <= 104:
               footlevel = 'B'
           elif 104 < footwidth <= 108:
               footlevel = 'C'
           elif 108 < footwidth <= 112:
               footlevel = 'D'
           elif 112 < footwidth:
               footlevel = 'E'
           # 210사이즈
       elif 205 < footlength <= 210:
           if footwidth <= 101:
               footlevel = 'A'
           elif 101 < footwidth <= 105:
               footlevel = 'B'
           elif 105 < footwidth <= 109:
               footlevel = 'C'
           elif 109 < footwidth <= 113:
               footlevel = 'D'
           elif 113 < footwidth:
               footlevel = 'E'

           # 215사이즈
       elif 210 < footlength <= 215:
           if footwidth <= 102:
               footlevel = 'A'
           elif 102 < footwidth <= 106:
               footlevel = 'B'
           elif 116 < footwidth <= 110:
               footlevel = 'C'
           elif 110 < footwidth <= 114:
               footlevel = 'D'
           elif 114 < footwidth:
               footlevel = 'E'

           # 220사이즈
       elif 215 < footlength <= 220:
           if footwidth <= 103:
               footlevel = 'A'
           elif 103 < footwidth <= 107:
               footlevel = 'B'
           elif 107 < footwidth <= 111:
               footlevel = 'C'
           elif 111 < footwidth <= 115:
               footlevel = 'D'
           elif 115 < footwidth:
               footlevel = 'E'

           # 225사이즈
       elif 220 < footlength <= 225:
           if footwidth <= 104:
               footlevel = 'A'
           elif 104 < footwidth <= 109:
               footlevel = 'B'
           elif 109 < footwidth <= 113:
               footlevel = 'C'
           elif 113 < footwidth <= 117:
               footlevel = 'D'
           elif 117 < footwidth:
               footlevel = 'E'

           # 230사이즈
       elif 225 < footlength <= 230:
           if footwidth <= 106:
               footlevel = 'A'
           elif 106 < footwidth <= 110:
               footlevel = 'B'
           elif 110 < footwidth <= 114:
               footlevel = 'C'
           elif 114 < footwidth <= 118:
               footlevel = 'D'
           elif 118 < footwidth:
               footlevel = 'E'

               # 235사이즈
       elif 230 < footlength <= 235:
           if footwidth <= 107:
               footlevel = 'A'
           elif 107 < footwidth <= 111:
               footlevel = 'B'
           elif 111 < footwidth <= 115:
               footlevel = 'C'
           elif 115 < footwidth <= 119:
               footlevel = 'D'
           elif 119 < footwidth:
               footlevel = 'E'

           # 240사이즈
       elif 235 < footlength <= 240:
           if footwidth <= 108:
               footlevel = 'A'
           elif 108 < footwidth <= 112:
               footlevel = 'B'
           elif 112 < footwidth <= 116:
               footlevel = 'C'
           elif 116 < footwidth <= 120:
               footlevel = 'D'
           elif 120 < footwidth:
               footlevel = 'E'

               # 245사이즈
       elif 240 < footlength <= 245:
           if footwidth <= 109:
               footlevel = 'A'
           elif 109 < footwidth <= 113:
               footlevel = 'B'
           elif 113 < footwidth <= 118:
               footlevel = 'C'
           elif 118 < footwidth <= 122:
               footlevel = 'D'
           elif 122 < footwidth:
               footlevel = 'E'

               # 250사이즈
       elif 245 < footlength <= 250:
           if footwidth <= 111:
               footlevel = 'A'
           elif 111 < footwidth <= 115:
               footlevel = 'B'
           elif 115 < footwidth <= 119:
               footlevel = 'C'
           elif 119 < footwidth <= 123:
               footlevel = 'D'
           elif 123 < footwidth:
               footlevel = 'E'

           # 255사이즈
       elif 250 < footlength <= 255:
           if footwidth <= 112:
               footlevel = 'A'
           elif 112 < footwidth <= 116:
               footlevel = 'B'
           elif 116 < footwidth <= 120:
               footlevel = 'C'
           elif 120 < footwidth <= 124:
               footlevel = 'D'
           elif 124 < footwidth:
               footlevel = 'E'

           # 260사이즈
       elif 255 < footlength <= 260:
           if footwidth <= 113:
               footlevel = 'A'
           elif 113 < footwidth <= 117:
               footlevel = 'B'
           elif 117 < footwidth <= 121:
               footlevel = 'C'
           elif 121 < footwidth <= 125:
               footlevel = 'D'
           elif 125 < footwidth:
               footlevel = 'E'

           # 265사이즈
       elif 260 < footlength <= 265:
           if footwidth <= 114:
               footlevel = 'A'
           elif 114 < footwidth <= 118:
               footlevel = 'B'
           elif 118 < footwidth <= 122:
               footlevel = 'C'
           elif 122 < footwidth <= 126:
               footlevel = 'D'
           elif 126 < footwidth:
               footlevel = 'E'

           # 270사이즈
       elif 265 < footlength <= 270:
           if footwidth <= 116:
               footlevel = 'A'
           elif 116 < footwidth <= 120:
               footlevel = 'B'
           elif 120 < footwidth <= 124:
               footlevel = 'C'
           elif 124 < footwidth <= 128:
               footlevel = 'D'
           elif 128 < footwidth:
               footlevel = 'E'

       # 275사이즈
       elif 270 < footlength <= 275:
           if footwidth <= 117:
               footlevel = 'A'
           elif 117 < footwidth <= 121:
               footlevel = 'B'
           elif 121 < footwidth <= 125:
               footlevel = 'C'
           elif 125 < footwidth <= 129:
               footlevel = 'D'
           elif 129 < footwidth:
               footlevel = 'E'

           # 280사이즈
       elif 275 < footlength <= 280:
           if footwidth <= 118:
               footlevel = 'A'
           elif 118 < footwidth <= 122:
               footlevel = 'B'
           elif 122 < footwidth <= 126:
               footlevel = 'C'
           elif 126 < footwidth <= 130:
               footlevel = 'D'
           elif 130 < footwidth:
               footlevel = 'E'

           # 285사이즈
       elif 280 < footlength <= 285:
           if footwidth <= 119:
               footlevel = 'A'
           elif 119 < footwidth <= 123:
               footlevel = 'B'
           elif 123 < footwidth <= 127:
               footlevel = 'C'
           elif 127 < footwidth <= 131:
               footlevel = 'D'
           elif 131 < footwidth:
               footlevel = 'E'

           # 290사이즈
       elif 285 < footlength <= 290:
           if footwidth <= 120:
               footlevel = 'A'
           elif 120 < footwidth <= 124:
               footlevel = 'B'
           elif 124 < footwidth <= 129:
               footlevel = 'C'
           elif 129 < footwidth <= 133:
               footlevel = 'D'
           elif 133 < footwidth:
               footlevel = 'E'

       users_ref3.update({'발볼 등급': footlevel})

       survey = users_ref3.get()

       # 가중치 계산리스트
       pos_score = []
       size_score = []
       price_score = []
       pur_score = []
       weight_score = []

       a = survey['포지션']
       for i in data:
           if a == 'FW':
               if i[8] == a:
                   pos_score.append(10)
               elif i[8] == 'MF':
                   pos_score.append(5)
               else:
                   pos_score.append(0)
           elif a == 'MF':
               if i[8] == a:
                   pos_score.append(10)
               elif i[8] == 'FW':
                   pos_score.append(5)
               else:
                   pos_score.append(5)
           elif a == 'DF':
               if i[8] == a:
                   pos_score.append(10)
               elif i[8] == 'MF':
                   pos_score.append(5)
               else:
                   pos_score.append(0)
       # b=footlevel
       b = survey['발볼 등급']

       for i in data:
           if b == 'A':
               if i[7] == 'A':
                   size_score.append(10)
               elif i[7] == 'B':
                   size_score.append(5)
               elif i[7] == 'C':
                   size_score.append(2.5)
               elif i[7] == 'D':
                   size_score.append(1.25)
               elif i[7] == 'E':
                   size_score.append(0.625)
           elif b == 'B':
               if i[7] == 'A':
                   size_score.append(5)
               elif i[7] == 'B':
                   size_score.append(10)
               elif i[7] == 'C':
                   size_score.append(5)
               elif i[7] == 'D':
                   size_score.append(2.5)
               elif i[7] == 'E':
                   size_score.append(1.25)
           elif b == 'C':
               if i[7] == 'A':
                   size_score.append(2.5)
               elif i[7] == 'B':
                   size_score.append(5)
               elif i[7] == 'C':
                   size_score.append(10)
               elif i[7] == 'D':
                   size_score.append(5)
               elif i[7] == 'E':
                   size_score.append(2.5)
           elif b == 'D':
               if i[7] == 'A':
                   size_score.append(1.25)
               elif i[7] == 'B':
                   size_score.append(2.5)
               elif i[7] == 'C':
                   size_score.append(5)
               elif i[7] == 'D':
                   size_score.append(10)
               elif i[7] == 'E':
                   size_score.append(5)
           if b == 'E':
               if i[7] == 'A':
                   size_score.append(0.625)
               elif i[7] == 'B':
                   size_score.append(1.25)
               elif i[7] == 'C':
                   size_score.append(2.5)
               elif i[7] == 'D':
                   size_score.append(5)
               elif i[7] == 'E':
                   size_score.append(10)
       c = survey['가격']
       for i in data:
           if int(c) < 100000:
               if int(i[3]) < 100000:
                   price_score.append(10)
               elif 100000 <= int(i[3]) < 200000:
                   price_score.append(5)
               elif 200000 <= int(i[3]) < 300000:
                   price_score.append(2.5)
               elif 300000 <= int(i[3]) < 400000:
                   price_score.append(1.25)
               elif int(i[3]) >= 400000:
                   price_score.append(0.625)
           if 100000 <= int(c) < 200000:
               if int(i[3]) < 100000:
                   price_score.append(10)
               elif 100000 <= int(i[3]) < 200000:
                   price_score.append(5)
               elif 200000 <= int(i[3]) < 300000:
                   price_score.append(2.5)
               elif 300000 <= int(i[3]) < 400000:
                   price_score.append(1.25)
               elif int(i[3]) >= 400000:
                   price_score.append(0.625)
           if 200000 <= int(c) < 300000:
               if int(i[3]) < 100000:
                   price_score.append(10)
               elif 100000 <= int(i[3]) < 200000:
                   price_score.append(5)
               elif 200000 <= int(i[3]) < 300000:
                   price_score.append(2.5)
               elif 300000 <= int(i[3]) < 400000:
                   price_score.append(1.25)
               elif int(i[3]) >= 400000:
                   price_score.append(0.625)
           if 300000 <= int(c) < 400000:
               if int(i[3]) < 100000:
                   price_score.append(10)
               elif 100000 <= int(i[3]) < 200000:
                   price_score.append(5)
               elif 200000 <= int(i[3]) < 300000:
                   price_score.append(2.5)
               elif 300000 <= int(i[3]) < 400000:
                   price_score.append(1.25)
               elif int(i[3]) >= 400000:
                   price_score.append(0.625)
           if int(c) >= 400000:
               if int(i[3]) < 100000:
                   price_score.append(10)
               elif 100000 <= int(i[3]) < 200000:
                   price_score.append(5)
               elif 200000 <= int(i[3]) < 300000:
                   price_score.append(2.5)
               elif 300000 <= int(i[3]) < 400000:
                   price_score.append(1.25)
               elif int(i[3]) >= 400000:
                   price_score.append(0.625)
       d = survey['사용용도']
       pur_score = []
       for i in data:  # 용도 점수
           if d == 'FG':
               if i[6] == 'FG':
                   pur_score.append(10)
               elif i[6] == 'AG':
                   pur_score.append(2.5)
               elif i[6] == 'HG':
                   pur_score.append(2.5)

           elif d == 'AG':
               if i[6] == 'FG':
                   pur_score.append(2.5)
               elif i[6] == 'AG':
                   pur_score.append(10)
               elif i[6] == 'HG':
                   pur_score.append(5)

           elif d == 'HG':
               if i[6] == 'FG':
                   pur_score.append(2.5)
               elif i[6] == 'AG':
                   pur_score.append(5)
               elif i[6] == 'HG':
                   pur_score.append(10)

       e = survey['무게']
       weight_score = []
       for i in data:
           if e == 'A':
               if i[9] == 'A':
                   weight_score.append(10)
               elif i[9] == 'B':
                   weight_score.append(5)
               elif i[9] == 'C':
                   weight_score.append(2.5)
               elif i[9] == 'D':
                   weight_score.append(1.25)
               elif i[9] == 'E':
                   weight_score.append(0.625)

           if e == 'B':
               if i[9] == 'A':
                   weight_score.append(1.25)
               elif i[9] == 'B':
                   weight_score.append(10)
               elif i[9] == 'C':
                   weight_score.append(5)
               elif i[9] == 'D':
                   weight_score.append(2.5)
               elif i[9] == 'E':
                   weight_score.append(0.625)
           if e == 'C':
               if i[9] == 'A':
                   weight_score.append(0.625)
               elif i[9] == 'B':
                   weight_score.append(1.25)
               elif i[9] == 'C':
                   weight_score.append(10)
               elif i[9] == 'D':
                   weight_score.append(5)
               elif i[9] == 'E':
                   weight_score.append(2.5)
           if e == 'D':
               if i[9] == 'A':
                   weight_score.append(0.625)
               elif i[9] == 'B':
                   weight_score.append(1.25)
               elif i[9] == 'C':
                   weight_score.append(2.5)
               elif i[9] == 'D':
                   weight_score.append(10)
               elif i[9] == 'E':
                   weight_score.append(5)
           if e == 'E':
               if i[9] == 'A':
                   weight_score.append(0.625)
               elif i[9] == 'B':
                   weight_score.append(1.25)
               elif i[9] == 'C':
                   weight_score.append(2.5)
               elif i[9] == 'D':
                   weight_score.append(5)
               elif i[9] == 'E':
                   weight_score.append(10)

       sum_score = [float(pos_score[i]) * 0.15 + float(size_score[i]) * 0.45 + float(price_score[i]) * 0.1 + float(
           pur_score[i]) * 0.3 + float(weight_score[i]) * 0.1 for i in range(len(pos_score))]
       x = sum_score.index(max(sum_score))

       if x == 0:
           users_ref2.update({
               '축구화 이름': football_list[x],
               '축구화 가격': football_price[x],
               '유사한 축구화1': football_list[x + 1],
               '유사한 축구화2': football_list[x + 2]
           })
       elif x == 169:
           users_ref2.update({
               '축구화 이름': football_list[x],
               '축구화 가격': football_price[x],
               '유사한 축구화1': football_list[x - 1],
               '유사한 축구화2': football_list[x - 2]
           })
       else:
           users_ref2.update({
               '축구화 이름': football_list[x],
               '축구화 가격': football_price[x],
               '유사한 축구화1': football_list[x - 1],
               '유사한 축구화2': football_list[x + 1]
           })

       users_ref1.update({
           '나이키': nike_list,
           '아디다스': adidas_list,
           '푸마': puma_list,
           '미즈노': mizuno_list

       })
       x = 0

