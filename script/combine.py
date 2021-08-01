from PIL import Image 
import os

# 文件前缀
fnprefix = "合成 1_" + "00" 
# 扫描目录
dir= "合成 1/"
# 文件数
n = 1
# 图像大小
sl = 16
sl = Image.open(dir + fnprefix + "000" + ".png").size[0]

for dir,subdir,files in os.walk(dir):
    n = len(files)

print("文件数：" + str(n))

putpng = Image.new("RGBA", (sl, sl * n))

for i in range(0, n):
    fp = ""
    if 0 <= i < 10:
        fp = dir + fnprefix + "00" + str(i) + ".png"
    elif 10 <= i < 100:
        fp = dir + fnprefix + "0" + str(i) + ".png"
    elif 100 <= i < 1000:
        fp = dir + fnprefix + "" + str(i) + ".png"

    eimg = Image.open(fp)
    box = [0, i * sl]
    putpng.paste(eimg, box)
    print("合成：" + fp)

putpng.save("outpng.png")
putpng.show()
