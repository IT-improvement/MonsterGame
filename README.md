![header](https://capsule-render.vercel.app/api?type=shark&color=auto&height=250&section=header&text=Monster%20Game&fontSize=90)
<div align=center>
<h1>Monster Game 제작</h1>
</div>

## 개요
### 프로젝트 명
  멀티클래스 RPG 레벨업 시뮬레이션<br>
### 프로젝트 설명
  이 프로젝트의 목표는 초보자에서 전사, 힐러, 마법사 세 가지의 직업을 가진 캐릭터들을 제어하여<br>
  여러 종류의 몬스터를 처치하고 레벨업하는 멀티클래스 RPG 시뮬레이션을 구현하는 것입니다. 
  <br>이를 통해 사용자는 다양한 전투 전략을 습득하고 캐릭터를 발전시키는 경험을 할 수 있습니다.<br>

<div align=center>
<h1>소개</h1>
</div>

## 기능
### 1.캐릭터 선택
사용자는 초보자, 전사, 힐러, 마법사 중 하나의 직업을 선택할 수 있습니다.
### 2.마을과 맵
게임은 마을과 세 개의 맵으로 구성됩니다.<br>
마을에서는 피와 마나를 회복할 수 있으며, 상점에서 아이템을 구입할 수 있습니다.<br>
맵에서는 몬스터와의 전투가 이뤄집니다.
### 3.전투시스템
전투는 턴제로 진행되며, 사용자는 각 캐릭터의 행동을 선택합니다.<br>
몬스터와의 전투에서 승리하면 경험치를 얻을 수 있습니다.
### 4.레벨
일정량의 경험치를 얻으면 캐릭터가 레벨업합니다.<br>
레벨업에 따라 능력치가 상승하고 새로운 스킬을 배울 수 있습니다.
### 5.다양한 몬스터
여러 종류의 몬스터가 존재하며, 각각의 몬스터는 고유한 능력과 전략을 가지고 있습니다.
### 6.저장 기능
게임 진행 상황을 저장하고 나중에 불러올 수 있는 기능을 제공합니다.

## 프로젝트 구조

```
├── README.md
└── src
     ├── main
     │     ├── Main.java
     │     ├── Game.java
     │     ├── Start.java
     │     ├── Scan.java
     │     └── FontStyle.java
     │
     ├── interfaces
     │     ├── Healable.java
     │     └── Skillable.java
     │
     ├── abstractClass
     │     ├── Item.java
     │     ├── Job.java
     │     ├── Life.java
     │     ├── Npc.java
     │     ├── Monster.java
     │     └── Map.java
     │
     ├── unit
     │     ├── Begginer.java
     │     ├── Healer.java
     │     ├── Warrior.java
     │     └── Wizard.java
     │          
     ├── monster
     │     ├── Golem.java
     │     └── Silme.java
     │   
     ├── map
     │     ├── SlimeAndGolemForest.java
     │     └── Town.java
     │   
     ├── user
     │     ├── User.java
     │     └── UserManager.java
     │   
     ├── item
     │     ├── Item.java
     │     ├── Weapon.java
     │     └── ItemManager.java
     │
     └── file
           ├── Golem.png
           ├── Slime.png
           ├── map.png
           └── monster.png
```
<br>

## Class Diagram
## Flow Chart

<div align=center>
<h1>소개</h1>
</div>

### 게임 방법

|이동방향|상(위)|좌(왼쪽)|하(아래)|우(오른쪽)|인벤토리|
|---|---|---|---|---|---|
|키보드| W | A | S | D | R |


### 게임 시작
<div align=center>
<img src="https://github.com/IT-improvement/MonsterGame/blob/master/Monster/src/imageFile/map.png">
</div>
게임시작 화면입니다.<br>
왼쪽에는 현재 위치한 맵, 오른쪽에는 캐릭터 상테창이 출력됩니다.<br>
  
### 맵 종류
|마을|슬라임의 숲|슬라임과 골렘의 숲|골렘의 소굴|
|---|---|---|---|
|<img src="https://github.com/IT-improvement/MonsterGame/blob/master/Monster/src/imageFile/Town.png">|<img src="https://github.com/IT-improvement/MonsterGame/blob/master/Monster/src/imageFile/SlimeForest.png">|<img src="https://github.com/IT-improvement/MonsterGame/blob/master/Monster/src/imageFile/SlimeAndGolemForest.png">|<img src="https://github.com/IT-improvement/MonsterGame/blob/master/Monster/src/imageFile/GolemForest.png">|

### NPC 종류
|길드|상점|파일|
|---|---|---|
|<img src="https://github.com/IT-improvement/MonsterGame/blob/master/Monster/src/imageFile/Gulid.png">|<img src="https://github.com/IT-improvement/MonsterGame/blob/master/Monster/src/imageFile/Shop.png">|<img src="https://github.com/IT-improvement/MonsterGame/blob/master/Monster/src/imageFile/file.png">| 

- 영상
<div align=center>
  <img src="https://github.com/IT-improvement/MonsterGame/blob/master/Monster/src/imageFile/npc.gif">
</div>

### 몬스터 등장
<div align=center>
<img src="https://github.com/IT-improvement/MonsterGame/blob/master/Monster/src/imageFile/monster.png">
</div>
몬스터 등장 화면입니다.<br>
몬스턴가 등장 후 몬스터 이름과 함께 사용자가 전투에서 선택할 수 있는 메뉴가 나옵니다.<br>

- 영상
<div align=center>
<img src="https://github.com/IT-improvement/MonsterGame/blob/master/Monster/src/imageFile/battle.gif">
</div>

### 몬스터 종류
<div align=center>
  
|슬라임|골렘|
|---|---|
|<img src="https://github.com/IT-improvement/MonsterGame/blob/master/Monster/src/imageFile/Slime.png">|<img src="https://github.com/IT-improvement/MonsterGame/blob/master/Monster/src/imageFile/Golem.png">|
</div>

<div align=center>
<h1>참고</h1>
</div>

### 싱글톤
- 싱글톤 생성은 개발자가 순서를 정할 수 없기때문에 싱글톤 클래스를 서로 사용할 경우 싱글톤이 필요할 때 getInstance해줘야 한다.



