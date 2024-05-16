from enum import IntEnum

class CategoriesEnum(IntEnum):
  NOVEL = 0
  THRILER = 1
  HISTORY = 2
  FANTASY = 3
  BIOGRAPHY = 4
  CLASSICS = 5
  DRAMA = 6
  
  @classmethod
  def choices(cls):
    return [(key.value, key.name) for key in cls]