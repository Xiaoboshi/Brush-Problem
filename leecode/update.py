# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'coderijiao.ui'
#
# Created by: PyQt5 UI code generator 5.6
#
# WARNING! All changes made in this file will be lost!

import os
import sys
import time
from lxml import etree
from selenium import webdriver
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities

from PyQt5 import QtCore, QtGui, QtWidgets
from PyQt5.QtWidgets import QMessageBox

class Ui_Form(object):
    def setupUi(self, Form):
        Form.setObjectName("Form")
        Form.resize(777, 584)
        self.pushButton = QtWidgets.QPushButton(Form)
        self.pushButton.setGeometry(QtCore.QRect(420, 20, 150, 50))
        font = QtGui.QFont()
        font.setFamily("Agency FB")
        font.setPointSize(24)
        self.pushButton.setFont(font)
        self.pushButton.setObjectName("pushButton")
        self.pushButton_2 = QtWidgets.QPushButton(Form)
        self.pushButton_2.setGeometry(QtCore.QRect(600, 20, 150, 50))
        font = QtGui.QFont()
        font.setFamily("Agency FB")
        font.setPointSize(24)
        self.pushButton.setFont(font)
        self.pushButton.setObjectName("pushButton")
        self.plainTextEdit = QtWidgets.QPlainTextEdit(Form)
        self.plainTextEdit.setGeometry(QtCore.QRect(210, 20, 150, 50))
        font = QtGui.QFont()
        font.setFamily("Agency FB")
        font.setPointSize(24)
        self.plainTextEdit.setFont(font)
        self.plainTextEdit.setVerticalScrollBarPolicy(QtCore.Qt.ScrollBarAlwaysOff)
        self.plainTextEdit.setHorizontalScrollBarPolicy(QtCore.Qt.ScrollBarAlwaysOff)
        self.plainTextEdit.setObjectName("plainTextEdit")
        self.label = QtWidgets.QLabel(Form)
        self.label.setGeometry(QtCore.QRect(60, 20, 150, 50))
        font = QtGui.QFont()
        font.setFamily("Agency FB")
        font.setPointSize(24)
        self.label.setFont(font)
        self.label.setLayoutDirection(QtCore.Qt.LeftToRight)
        self.label.setAlignment(QtCore.Qt.AlignCenter)
        self.label.setObjectName("label")
        self.label_2 = QtWidgets.QLabel(Form)
        self.label_2.setGeometry(QtCore.QRect(160, 100, 100, 50))
        font = QtGui.QFont()
        font.setFamily("Agency FB")
        font.setPointSize(24)
        self.label_2.setFont(font)
        self.label_2.setAlignment(QtCore.Qt.AlignCenter)
        self.label_2.setObjectName("label_2")
        self.label_3 = QtWidgets.QLabel(Form)
        self.label_3.setGeometry(QtCore.QRect(530, 100, 100, 50))
        font = QtGui.QFont()
        font.setFamily("Agency FB")
        font.setPointSize(24)
        self.label_3.setFont(font)
        self.label_3.setAlignment(QtCore.Qt.AlignCenter)
        self.label_3.setObjectName("label_3")
        self.textEdit = QtWidgets.QTextEdit(Form)
        font = QtGui.QFont()
        font.setFamily("Agency FB")
        font.setPointSize(24)
        self.textEdit.setFont(font)
        self.textEdit.setGeometry(QtCore.QRect(80, 150, 300, 400))
        self.textEdit.setObjectName("textEdit")
        self.textEdit_2 = QtWidgets.QTextEdit(Form)
        font = QtGui.QFont()
        font.setFamily("Agency FB")
        font.setPointSize(24)
        self.textEdit_2.setFont(font)
        self.textEdit_2.setGeometry(QtCore.QRect(430, 150, 300, 400))
        self.textEdit_2.setObjectName("textEdit_2")

        self.retranslateUi(Form)
        QtCore.QMetaObject.connectSlotsByName(Form)

    def retranslateUi(self, Form):
        _translate = QtCore.QCoreApplication.translate
        Form.setWindowTitle(_translate("Form", "Form"))
        self.pushButton.setText(_translate("Form", "submit"))
        self.pushButton_2.setText(_translate("Form", "clear"))
        self.label.setText(_translate("Form", "题号："))
        self.label_2.setText(_translate("Form", "描述"))
        self.label_3.setText(_translate("Form", "CODE"))


class myForm(QtWidgets.QWidget, Ui_Form):
    def __init__(self):
        super(myForm, self).__init__()
        self.setupUi(self)
        self.pushButton.clicked.connect(self.submit)
        self.pushButton_2.clicked.connect(self.cleartext)

    # # 前台开启浏览器模式
    # def openChrome(self):
    #     # 加启动配置
    #     option = webdriver.ChromeOptions()
    #     option.add_argument('disable-infobars')
    #     # 打开chrome浏览器
    #     driver = webdriver.Chrome(chrome_options=option)
    #     return driver

    
    # # 授权操作
    # def operationAuth(self, driver, num):
    #     url = "https://leetcode-cn.com/problemset/all/?search=" + str(num)
    #     driver.get(url)
    #     # 找到输入框并输入查询内容
    #     # 获取checkbox并勾选
    #     data = driver.page_source
    #     ps = etree.HTML(data)
    #     table = ps.xpath("//div[@class='table-responsive question-list-table']//tbody[@class='reactable-data']/tr/td/text()")
    #     count = 0
    #     for i in table:
    #         if i == str(num):
    #             break
    #         count += 1

    #     ele = ps.xpath("//div[@class='table-responsive question-list-table']//tbody[@class='reactable-data']/tr[" + str(count)+ "]//div[@class='question-title']/a/@href")
    #     if len(ele) == 0:
    #         return ""

    #     nexturl = "https://leetcode-cn.com/" + ele[0]
    #     print(nexturl)
    #     return nexturl

    #定义槽函数,用于提交
    def submit(self):
        discribe = self.textEdit.toPlainText()
        code = self.textEdit_2.toPlainText()
        num = self.plainTextEdit.toPlainText()
        if len(discribe) != 0 and len(code) != 0 and len(num) != 0:
            os_dir = "./code/" + str(num) + '/'
            if not os.path.exists(os_dir):
                os.makedirs(os_dir)
            
            file_dis = open(os_dir + "README.md", "w", encoding='utf-8')
            file_dis.write(discribe)
            file_dis.close()

            file_code = open(os_dir + str(num) + ".java", "w", encoding='utf-8')
            file_code.write(code)
            file_code.close()
            
            QMessageBox.question(self, "提示信息", "添加成功", QMessageBox.Yes | QMessageBox.No)

        else:
            QMessageBox.question(self, "提示信息", "需要输入内容", QMessageBox.Yes | QMessageBox.No)
    
    
    # 定义槽函数，用于清除输入
    def cleartext(self):
        self.textEdit.setText("")
        self.textEdit_2.setText("")
        self.plainTextEdit.setPlainText("")
        QMessageBox.question(self, "提示信息", "内容清空", QMessageBox.Yes | QMessageBox.No)


if __name__ == "__main__":  
    app = QtWidgets.QApplication(sys.argv) 
    window = myForm()
    window.show()
    sys.exit(app.exec_())