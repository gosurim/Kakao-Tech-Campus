import shutil
import os

# 이동할 원본 폴더들
source_folders = ['CalculatorProject', 'Lv2_Calculator', 'Lv3_Calculator']

# 새로운 폴더 (목표 폴더)
destination_folder = 'gitHowToUseee'

# Projects 폴더가 없으면 새로 만듭니다.
if not os.path.exists(destination_folder):
    os.makedirs(destination_folder)

# 원본 폴더들을 새 폴더로 이동
for folder in source_folders:
    # 폴더가 존재하면 이동
    if os.path.exists(folder):
        shutil.move(folder, destination_folder)
        print(f"{folder} 폴더를 {destination_folder}로 이동했습니다.")
    else:
        print(f"{folder} 폴더가 존재하지 않습니다.")

print("모든 폴더가 이동되었습니다.")
